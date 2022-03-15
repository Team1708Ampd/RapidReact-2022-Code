package frc.robot.output.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class TeleopDrive extends Command {

    private SwerveWheelController swerve = null;

    private boolean currentFOD = false;

    public TeleopDrive(){
        swerve = SwerveWheelController.getInstance();

        requires(swerve);
    }

    @Override
    public void initialize(){
        currentFOD = swerve.getFOD();

        swerve.resetGyro();
    }

    @Override
    public void execute() {

        System.out.printf("Robot left stick: %.2f\n", Robot.joystick.getControllerLeftStickX());
      
        swerve.drive(Robot.joystick.getControllerLeftStickX(), Robot.joystick.getControllerLeftStickY(), Robot.joystick.getControllerRightStickX(), swerve.gyroAngle());
    
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }
}
