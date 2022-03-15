// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Vision.Limelight;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class SeekTargetCommand extends Command {

  SwerveWheelController driveModule;
  Limelight limeModule;

  public SeekTargetCommand(SwerveWheelController drive, Limelight lime) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    driveModule = drive;
    limeModule = lime;
    
    requires(Robot.swerve);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveModule.turnAtSpeed(0.3, 90);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return limeModule.validTargets();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
