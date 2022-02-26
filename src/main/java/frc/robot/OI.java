// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.simulation.XboxControllerSim;
import frc.robot.Commands.ElevatorDown;
import frc.robot.Commands.ElevatorUp;
import frc.robot.Commands.IndexerForward;
import frc.robot.Commands.IndexerReverse;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.OuttakeCommand;


/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class OI {
  XboxController joystick = new XboxController(0);
  Button intake = new JoystickButton(joystick, 5);
  Button outtake = new JoystickButton(joystick, 6);
  Button elevatorUp = new JoystickButton(joystick, 1);
  Button elevatorDown = new JoystickButton(joystick, 2);
  Button indexerForward = new JoystickButton(joystick, 3);
  Button indexerReverse = new JoystickButton(joystick, 4);
  Button shooter = new JoystickButton(joystick, 7);
  public OI(){
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  intake.whileHeld(new IntakeCommand());
  outtake.whileHeld(new OuttakeCommand());
  elevatorDown.whileHeld(new ElevatorDown());
  elevatorUp.whileHeld(new ElevatorUp());
  indexerForward.whileHeld(new IndexerForward());
  indexerReverse.whileHeld(new IndexerReverse());
  }
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
