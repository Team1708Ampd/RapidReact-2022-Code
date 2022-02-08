package frc.robot.output.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
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
        if (Robot.joystick.getAButtonPressed()) {
            swerve.resetGyro();
        }

        if (Robot.joystick.getBButtonPressed()) {
            currentFOD = !currentFOD;
            swerve.setFOD(currentFOD);
        }

        swerve.drive(Robot.joystick.getRawAxis(0), Robot.joystick.getRawAxis(1), Robot.joystick.getRawAxis(4), swerve.gyroAngle());
    }
}
