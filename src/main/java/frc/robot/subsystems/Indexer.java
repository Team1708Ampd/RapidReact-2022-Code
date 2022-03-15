// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Indexer extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX indexer = new WPI_VictorSPX(15);
  WPI_VictorSPX angledIndexer = new WPI_VictorSPX(16);
  Timer ballIndexTimer = new Timer();
  private final double BALL_INDEXER_TIME = 2;
  private boolean indexingStarted = false;

  public void indexerForward(){
    indexer.set(ControlMode.PercentOutput, 1);
    angledIndexer.set(ControlMode.PercentOutput, -1);

  }

  public void indexerReverse(){
    indexer.set(ControlMode.PercentOutput, -1);
    angledIndexer.set(ControlMode.PercentOutput, 1);

  }

  public void indexerOff(){
    indexer.set(ControlMode.PercentOutput, 0);
    angledIndexer.set(ControlMode.PercentOutput, 0);
    indexingStarted = true;
  }

  public void indexBall()
  {
      ballIndexTimer.start();
      ballIndexTimer.reset();
      indexerReverse();
      indexingStarted = true;
  }

  public boolean ballIndexed()
  {
    boolean indexed = false;

    if (ballIndexTimer.hasElapsed(BALL_INDEXER_TIME))
    {
      indexed = true;
    }

    return indexed;
  }

  public boolean indexingStarted()
  {
    return indexingStarted;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
