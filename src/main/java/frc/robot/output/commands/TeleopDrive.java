package frc.robot.output.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Commands.IntakeCommand;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class TeleopDrive extends CommandBase {

    private SwerveWheelController swerve = null;

    private boolean currentFOD = false;

    public TeleopDrive(){
        swerve = SwerveWheelController.getInstance();

        addRequirements(swerve);
    }

    @Override
    public void initialize(){
        currentFOD = swerve.getFOD();

        swerve.resetGyro();
    }

    @Override
    public void execute() {
        if (Robot.joystick.getControllerAButtonPressed()) {
            //swerve.resetGyro();
        }


        if (Robot.joystick.getControllerBButtonPressed()) {
            currentFOD = !currentFOD;
            swerve.setFOD(currentFOD);
        }
      
        swerve.drive(Robot.joystick.getControllerLeftStickX(), Robot.joystick.getControllerLeftStickY(), 0, swerve.gyroAngle());
    }
}
