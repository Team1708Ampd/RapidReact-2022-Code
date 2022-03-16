// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class AutoCommandGroup extends CommandGroup {
  /** Add your docs here. */
  public AutoCommandGroup() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.
    addParallel(new SpoolShooter());
    addParallel(new LoadBall());
    addSequential(new FireShot());
    addSequential(new TurnToAngleCommand(0.5, 0, 0, Robot.swerve, 180, true));
    addSequential(new DriveForward(Robot.swerve, 1));
    //addParallel(new AutoIntakeCommand());

    /*TODO: create an autonomous intake command to run while driving forward to grab a second ball
            
    */
    
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
