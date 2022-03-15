// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LoadBall extends Command {
  public LoadBall() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.indexer);
  
  }
  boolean ballLoaded;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    ballLoaded = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (!Robot.indexer.indexingStarted())
    {
      Robot.indexer.indexBall();
    }
            
    if (Robot.indexer.ballIndexed())
    {
      ballLoaded = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return ballLoaded;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.indexer.indexerOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.indexer.indexerOff();
  }
}
