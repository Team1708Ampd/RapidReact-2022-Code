// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.TurnToAngleCommand;
import frc.robot.output.commands.TeleopDrive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Spool;
import frc.robot.subsystems.Vision.Limelight;
import frc.robot.subsystems.AutoCommandModule;
import frc.robot.subsystems.ClimberHook;
import frc.robot.subsystems.Climbers;
import frc.robot.subsystems.controller.Controller;
import frc.robot.subsystems.drivetrain.SwerveWheelController;
import frc.robot.subsystems.IntakeArm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.LineEvent;

import com.ctre.phoenix.motorcontrol.ControlMode;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private Command m_autonomousCommand;
  public static SwerveWheelController swerve;
  private static Scheduler scheduler = Scheduler.getInstance();
  public static Intake intake = new Intake();
  public static Elevator elevator = new Elevator();
  public static Indexer indexer = new Indexer();
  public static Shooter shooter = new Shooter();
  public static Spool spooler = new Spool();
  public static Climbers climberBoys = new Climbers();
  public static ClimberHook captHook = new ClimberHook();
  public static IntakeArm intakeArm = new IntakeArm();
  public static OI m_oi;

  public static Controller joystick = new Controller(0);
  public static TeleopDrive drive = new TeleopDrive();
  public static Limelight lime;
  public static AutoCommandModule autoCommand;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.0
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    swerve = SwerveWheelController.getInstance();
    lime = Limelight.getInstance();
    lime.setPipeline(1);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    Scheduler.getInstance().run();
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);   

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      scheduler.add(m_autonomousCommand);
      //Scheduler.getInstance().run();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
      


  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() 
  {
    System.out.println("Teleop operation started");
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    } 
    drive.initialize();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() 
  {
    drive.execute();
    Scheduler.getInstance().run();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    scheduler.run();
  }
}
