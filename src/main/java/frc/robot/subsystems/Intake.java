// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX intakeMotor = new WPI_VictorSPX(13);

  public void intake(){
      intakeMotor.set(ControlMode.PercentOutput, 1);
  }

  public void outtake(){
      intakeMotor.set(ControlMode.PercentOutput, -1);
  }

  public void intakeOff(){
      intakeMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

