package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrame;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class SwerveWheel extends PIDSubsystem implements SwerveDrivetrainConstants {

    public String name;

    private WPI_TalonFX steerMotor;
    private CANCoder absEnc;
    private SwerveWheelDrive drive;

    private int countsWhenFrwd;

    public SwerveWheel(SwerveWheelDrive drive, int m_steer, int analogEnc, int zeroOffset, String name, 
                       double kP, double kI, double kD) {
        super(kP, kI, kD);

        this.name = name;

        this.drive = drive;
       
        countsWhenFrwd = zeroOffset;
        
        steerMotor = new WPI_TalonFX(m_steer);

        updateStatusFrames(steerMotor);
        
        absEnc = new CANCoder(analogEnc);
           
        // Reset all of the settings on startup
        steerMotor.configFactoryDefault();

        // Set the feedback device for the steering (turning) Talon SRX
        steerMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
       
        // Set the current quadrature position relative to the analog position to make sure motor has 0 position on startup
        steerMotor.setSelectedSensorPosition(getAbsAngleDeg());

        // Set the input range of the PIDF so that it will only accept angles between -180 to 180 and set it to continuous
        getPIDController().setInputRange(-180, 180);

        getPIDController().setContinuous();

    }

    // Get the current angle of the analog encoder
    private int getAbsAngleDeg(){
        
        // Perform the calculation for the external encoder
        return (int)((absEnc.getAbsolutePosition() - countsWhenFrwd));  
    }

    // Get current ticks
    public double getTicks() {
        return steerMotor.getSelectedSensorPosition();
    }

    public void setSpeed(double speed) {
        drive.setSpeed(speed);
    }

    @Override
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        return getAbsAngleDeg();
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub
        //System.out.printf("PID Output: %f\n", output);
        steerMotor.set(ControlMode.PercentOutput, output);
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }

    private void updateStatusFrames(WPI_TalonFX motor)
    {
        motor.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 255);       
        motor.setStatusFramePeriod(StatusFrame.Status_10_MotionMagic, 255);        
        motor.setStatusFramePeriod(StatusFrame.Status_4_AinTempVbat, 255);      
        motor.setStatusFramePeriod(StatusFrame.Status_6_Misc, 255);     
        motor.setStatusFramePeriod(StatusFrame.Status_10_Targets, 255);        
        motor.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 255);        
        motor.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 255);      
    }
}
