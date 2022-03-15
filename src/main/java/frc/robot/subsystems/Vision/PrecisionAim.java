package frc.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class PrecisionAim extends PIDSubsystem{

    SwerveWheelController DriveModule;
    Limelight LimeModule;

    public PrecisionAim(double p, double i, double d, Limelight lime, SwerveWheelController drive) {
        super(p, i, d);
        //TODO Auto-generated constructor stub
        LimeModule = lime;
        DriveModule = drive;

        getPIDController().setAbsoluteTolerance(0.5);  

    }


    @Override
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        System.out.printf("Target X: %.2f\n", LimeModule.targetX());

        return LimeModule.targetX();
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub

        DriveModule.turnAtSpeed(output, 90);
        System.out.printf("PID Effort: %.2f\n", output);
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }

    public void NewTarget()
    {
        getPIDController().enable();
        getPIDController().setSetpoint(0.0);
    }

    public void EndAim()
    {
        getPIDController().disable();
    }
    
}
