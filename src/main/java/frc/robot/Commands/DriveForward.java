// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class DriveForward extends Command {
  SwerveWheelController driveModule;
  double delay;
  Timer time = new Timer();
  public DriveForward( SwerveWheelController drive, double time) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    driveModule = drive;
    delay = time;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    time.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveModule.driveForward(0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return time.hasElapsed(delay);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driveModule.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    driveModule.stop();
  }
}
