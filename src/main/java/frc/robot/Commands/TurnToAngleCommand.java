package frc.robot.commands;

import com.kauailabs.navx.AHRSProtocol.TuningVar;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.drivetrain.SwerveWheelController;


public class TurnToAngleCommand extends PIDCommand{

    SwerveWheelController driveController;
    Double turnAngle;
    
    public TurnToAngleCommand(double p, double i, double d, SwerveWheelController drive, double targetAngle, boolean clockwise) {
        super(p, i, d);
        //TODO Auto-generated constructor stub
        driveController = drive;

        getPIDController().setInputRange(-180, 180);
        getPIDController().setAbsoluteTolerance(5);
        getPIDController().setContinuous();        
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setSetpoint(targetAngle);

        turnAngle = 90.0;
        
        if(!clockwise)
        {
            turnAngle *= (-1);
        }
    }

    @Override
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        return driveController.gyroAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub 
        
        driveController.turnAtSpeed(output, turnAngle);  
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return getPIDController().onTarget();
    }    
}
