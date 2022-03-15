package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.subsystems.Vision.Limelight;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class AimbotAimCommand extends PIDCommand{

    SwerveWheelController DriveModule;
    Limelight LimeModule;

    public AimbotAimCommand(double p, double i, double d, Limelight lime, SwerveWheelController drive) {
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

    public void NewTarget()
    {
        getPIDController().enable();
        getPIDController().setSetpoint(0.0);
    }

    public void EndAim()
    {
        getPIDController().disable();
    }


    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
