// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class ClimberHook extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Solenoid hookSolenoid = new Solenoid(30, PneumaticsModuleType.REVPH, 0);

  public void engageHook(){
    hookSolenoid.set(true);
  }
  public void disengageHook(){
    hookSolenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

