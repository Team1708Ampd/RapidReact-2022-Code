// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.simulation.XboxControllerSim;
import frc.robot.commands.ElevatorDown;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.IndexerForward;
import frc.robot.commands.IndexerReverse;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.RetractClimbersCommand;
import frc.robot.commands.ExtendClimbersCommand;
import frc.robot.commands.SpoolShooterCommand;
import frc.robot.commands.ExtendIntakeCommand;
import frc.robot.commands.RetractIntakeCommand;
import frc.robot.commands.ShootBallCommand;
import frc.robot.commands.EngageClimberHookCommand;
import frc.robot.commands.DisengageClimberHookCommand;
import frc.robot.subsystems.controller.JoystickTrigger;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class OI {
  XboxController joystick = new XboxController(0);  
  Button indexerAndElevatorFW = new JoystickButton(joystick, 5); // XBOX Controller Right Bumper
  Button indexerAndElevatorRV = new JoystickButton(joystick, 6); // XBOX Controller Left Bumper  
  Button intake = new JoystickTrigger(joystick, 2);              // XBOX Controller Left Trigger
  Button shooter = new JoystickTrigger(joystick, 3);             // XBOX Controller Right Trigger 
  Button retractClimbers = new JoystickButton(joystick, 3);      // XBOX Controller X Button
  Button extendClimbers = new JoystickButton(joystick, 4);       // XBOX Controller Y Button
  Button engageThehook = new JoystickButton(joystick, 8);        // XBOX Controller Start Button
  Button disengageTheHook = new JoystickButton(joystick, 7);     // XBOX Controller Back Button
  Button extendIntake = new JoystickButton(joystick, 10);        // XBOX Controller Right stick Button
  Button retractIntake = new JoystickButton(joystick, 9);        // XBOX Controller Left stick Button
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
  indexerAndElevatorFW.whileHeld(new IndexerForward());
  indexerAndElevatorRV.whileHeld(new IndexerReverse());
  shooter.whileHeld(new ShootBallCommand());
  retractClimbers.whileHeld(new RetractClimbersCommand());
  extendClimbers.whileHeld(new ExtendClimbersCommand());  
  engageThehook.whileHeld(new EngageClimberHookCommand()); 
  disengageTheHook.whileHeld(new DisengageClimberHookCommand());  
  extendIntake.whenPressed(new ExtendIntakeCommand()); 
  retractIntake.whenPressed(new RetractIntakeCommand()); 

  }
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
