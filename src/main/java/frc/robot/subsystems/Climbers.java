// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Climbers extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonFX rightClimber = new WPI_TalonFX(19);
  WPI_TalonFX leftClimber = new WPI_TalonFX(20);

  public final double CLIMBER_MOTOR_OUTPUT_POWER = 0.50;

  public void Climbers()
  {
    // Change status frames data return period to avoid overusing the CAN bus
     rightClimber.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 255);
     rightClimber.setStatusFramePeriod(StatusFrame.Status_10_MotionMagic, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_10_MotionMagic, 255);
     rightClimber.setStatusFramePeriod(StatusFrame.Status_4_AinTempVbat, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_4_AinTempVbat, 255);
     rightClimber.setStatusFramePeriod(StatusFrame.Status_6_Misc, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_6_Misc, 255);
     rightClimber.setStatusFramePeriod(StatusFrame.Status_10_Targets, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_10_Targets, 255);
     rightClimber.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 255);
     rightClimber.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 255);
     leftClimber.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 255);

     // Set both motors neutral mode to brake

     rightClimber.setNeutralMode(NeutralMode.Brake);
     leftClimber.setNeutralMode(NeutralMode.Brake);
  }

  public void extendClimbers(){
    rightClimber.set(ControlMode.PercentOutput, ((-1) * CLIMBER_MOTOR_OUTPUT_POWER));
    leftClimber.set(ControlMode.PercentOutput, CLIMBER_MOTOR_OUTPUT_POWER);
  }
  public void retractClimbers(){
    rightClimber.set(ControlMode.PercentOutput, CLIMBER_MOTOR_OUTPUT_POWER);
    leftClimber.set(ControlMode.PercentOutput, ((-1) * CLIMBER_MOTOR_OUTPUT_POWER));
  }
  public void climbersOff(){
    rightClimber.stopMotor();
    leftClimber.stopMotor();;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

