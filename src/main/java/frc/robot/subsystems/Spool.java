// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Spool extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax spoolShooterMotorL = new CANSparkMax(23, MotorType.kBrushless);
  CANSparkMax spoolShooterMotorR = new CANSparkMax(21, MotorType.kBrushless);


  public void RaiseShooterHood()
  {

  }

  public void SpoolShooter()
  {
    spoolShooterMotorL.set(-0.67);
    spoolShooterMotorR.set(0.67);
  }

  public void SpoolOff()
  {
    spoolShooterMotorL.set(0);
    spoolShooterMotorR.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
