// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax loadBallMotor = new CANSparkMax(22, MotorType.kBrushless);
  Timer ballShootTimer = new Timer();
  private final double BALL_SHOOT_TIME = 5;

  public Shooter()
  {
    ballShootTimer.stop();
  }

  public void Shoot(){
    loadBallMotor.set(1.0);
  }

  public void ShooterOff()
  {
    loadBallMotor.set(0);
    ballShootTimer.stop();
  }

  public void fireShooter()
  {
    Shoot();
    ballShootTimer.start();
    ballShootTimer.reset();
  }

  public boolean isShotFired()
  {
    return ballShootTimer.hasElapsed(BALL_SHOOT_TIME);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
