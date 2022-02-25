package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class SwerveWheel extends PIDSubsystem implements SwerveDrivetrainConstants {

    public String name;

    private WPI_TalonFX steerMotor;
    private CANCoder absEnc;
    private SwerveWheelDrive drive;

    private int countsWhenFrwd;

    public SwerveWheel(SwerveWheelDrive drive, int m_steer, int analogEnc, int zeroOffset, String name, 
                       double kP, double kI, double kD) {
        super(new PIDController(kP, kI, kD));

        this.name = name;

        this.drive = drive;
       
        countsWhenFrwd = zeroOffset;
        
        steerMotor = new WPI_TalonFX(m_steer);
        absEnc = new CANCoder(analogEnc);

        // Reset all of the settings on startup
        steerMotor.configFactoryDefault();

        // Set the feedback device for the steering (turning) Talon SRX
        steerMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

        // Set the current quadrature position relative to the analog position to make sure motor has 0 position on startup
        steerMotor.setSelectedSensorPosition(getAbsAngleDeg());

        // Set the input range of the PIDF so that it will only accept angles between 0 to 360 and set it to continuous
        getController().enableContinuousInput(-180, 180);

        // Sets name for viewing in SmartDashboard
        this.setName(name);
    }

    // Get the current angle of the analog encoder
    private int getAbsAngleDeg(){
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
    protected double getMeasurement() {
        return getAbsAngleDeg();
    }

    @Override
    protected void useOutput(double output, double setpoint) {
        steerMotor.set(ControlMode.PercentOutput, output);
    }
}
