package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.drivetrain.SwerveWheelController;


public class TurnToAngleCommand extends PIDCommand{

    SwerveWheelController driveController;
    
    public TurnToAngleCommand(double p, double i, double d, SwerveWheelController drive, double targetAngle) {
        super(p, i, d);
        //TODO Auto-generated constructor stub
        driveController = drive;

        getPIDController().setInputRange(-180, 180);
        getPIDController().setAbsoluteTolerance(5);
        getPIDController().setContinuous();        
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setSetpoint(targetAngle);

    }

    @Override
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        return driveController.gyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub 
        //driveController.turn(90);
        //driveController.turnAtSpeed(output);    
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return getPIDController().onTarget();
    }
    
}
