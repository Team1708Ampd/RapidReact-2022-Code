package frc.robot.subsystems.drivetrain;

import frc.robot.output.commands.TeleopDrive;


import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drivetrain.SwerveWheel;
import frc.robot.subsystems.drivetrain.SwerveWheelDrive;
import frc.robot.subsystems.drivetrain.SwerveWheelDrive.SwerveWheelDriveType;

import com.kauailabs.navx.frc.AHRS;

public class SwerveWheelController extends SubsystemBase implements SwerveDrivetrainConstants {

    private static SwerveWheelController instance = null;

    private SwerveWheelDrive frontRightDrive = null;
    private SwerveWheelDrive frontLeftDrive = null;
    private SwerveWheelDrive backRightDrive = null;
    private SwerveWheelDrive backLeftDrive = null;
    
    public SwerveWheel frontRight = null;
    public SwerveWheel frontLeft = null;
    public SwerveWheel backRight = null;
    public SwerveWheel backLeft = null;

    private AHRS gyro = null;

    // Get distance between wheels
    private double r = Math.sqrt((L * L) + (W * W));

    private boolean isFieldCentric = false;
    private boolean gyroEnabled = false;
    
    private SwerveWheelController(){

        frontRightDrive = new SwerveWheelDrive(SwerveWheelDriveType.TalonFX, frontRightDriveID, true);
        frontLeftDrive = new SwerveWheelDrive(SwerveWheelDriveType.TalonFX, frontLeftDriveID, false);
        backRightDrive = new SwerveWheelDrive(SwerveWheelDriveType.TalonFX, backRightDriveID, true);
        backLeftDrive = new SwerveWheelDrive(SwerveWheelDriveType.TalonFX, backLeftDriveID, false);

        frontRight = new SwerveWheel(frontRightDrive, frontRightTurnTalonID, frontRightEncoderID, frontRightEncoderOffset, "Front Right",
                                     kPFR, kIFR, kDFR);
        frontLeft = new SwerveWheel(frontLeftDrive, frontLeftTurnTalonID, frontLeftEncoderID, frontLeftEncoderOffset, "Front Left",
                                    kPFL, kIFL, kDFL);
        backRight = new SwerveWheel(backRightDrive, backRightTurnTalonID, backRightEncoderID, backRightEncoderOffset, "Back Right",
                                    kPBR, kIBR, kDBR);
        backLeft = new SwerveWheel(backLeftDrive, backLeftTurnTalonID, backLeftEncoderID, backLeftEncoderOffset, "Back Left",
                                    kPBL, kIBL, kDBL);

        try {
            gyro = new AHRS(SPI.Port.kMXP); 
            gyroEnabled = true;
        } catch (RuntimeException ex ) {
            System.out.println("--------------");
            System.out.println("NavX not plugged in");
            System.out.println("--------------");
            gyroEnabled = false;
        }

        frontRight.enable();
        frontLeft.enable();
        backRight.enable();
        backLeft.enable();
    }

    // x1 = strafe, y1 = speed, x2 = rotation 
    // Holonomic drive
    public void drive(double x1, double y1, double x2, double gyroValue) {

        y1 *= -1;

        // Calculate magnitude of joystick
        double magnitude = Math.sqrt((Math.pow(x1, 2)) + (Math.pow(y1,2)));

        if (magnitude >= 0.15) {

            // I got this bit of code from the NavX website
            if (isFieldCentric == true && gyroEnabled == true) {
                // Convert gyro angle to radians
                double gyro = gyroValue * Math.PI / 180;

                double temp = x1 * Math.cos(gyro) + y1 * Math.sin(gyro); 
                y1 = -x1 * Math.sin(gyro) + y1 * Math.cos(gyro); 
                x1 = temp;
            }

            // -------------------------------------
            // Do the swerve wheel math for speed and angles
            // -------------------------------------
            double a = x1 - x2 * (L / r);
            double b = x1 + x2 * (L / r);
            double c = y1 - x2 * (W / r);
            double d = y1 + x2 * (W / r);

            double frontLeftSpeed = Math.sqrt((b * b) + (c * c));
            double frontRightSpeed = Math.sqrt((b * b) + (d * d));
            double backRightSpeed = Math.sqrt((a * a) + (d * d));
            double backLeftSpeed = Math.sqrt((a * a) + (c * c));

            double backRightAngle = Math.atan2(a, d) * 180 / Math.PI;
            double backLeftAngle = Math.atan2(a, c) * 180 / Math.PI;
            double frontRightAngle = Math.atan2(b, d) * 180 / Math.PI;
            double frontLeftAngle = Math.atan2(b, c) * 180 / Math.PI ;
            // -------------------------------------
            

            // -------------------------------------
            // This bit of code normalizes the speed
            // -------------------------------------
            double max = frontLeftSpeed * 0.0001;
            max = Math.max(max, frontRightSpeed);
            max = Math.max(max, backRightSpeed);
            max = Math.max(max, backLeftSpeed);

            if (max > 1) {
                frontLeftSpeed /= max;
                frontRightSpeed /= max;
                backRightSpeed /= max;
                backLeftSpeed /= max;
            }
            // -------------------------------------
            //System.out.printf("Gyro Value: %f\n", gyroValue);
            //System.out.printf("Front Right measured angle error: %f\n", frontRight.getMeasurement());
            //System.out.printf("Front Left measured angle: %f\n", frontLeftAngle);
            //System.out.printf("Front Left measured angle error: %f\n", frontLeftAngle - frontLeft.getMeasurement());
            //System.out.printf("Back Right measured angle error: %f\n", backRight.getMeasurement());
            System.out.printf("Back Left measured angle error: %f\n", backLeft.getMeasurement());
            frontRight.setSetpoint(frontRightAngle);
            frontLeft.setSetpoint(frontLeftAngle);
            backRight.setSetpoint(backRightAngle);
            backLeft.setSetpoint(backLeftAngle);

            frontLeft.setSpeed(frontLeftSpeed);
            frontRight.setSpeed(frontRightSpeed);
            backRight.setSpeed(backRightSpeed);
            backLeft.setSpeed(backLeftSpeed);
        } 
        else {
            frontLeft.setSpeed(0);
            frontRight.setSpeed(0);
            backRight.setSpeed(0);
            backLeft.setSpeed(0);
        }
    }

    // Zero the Gryo
    public void resetGyro() {
        gyro.reset();
    }

    // Get the Gyro Angle (-180 to 180)
    public double gyroAngle() {
        return gyro.getYaw();
    }

    // Set the controller to be field oriented drive
    public void setFOD(boolean value) {
        isFieldCentric = value;
    }

    // Get the current FOD mode
    public boolean getFOD() {
        return isFieldCentric;
    }

    /**
     * @return the instance
     */
    public static SwerveWheelController getInstance() {
        if (instance == null) {
            instance = new SwerveWheelController();
            instance.setDefaultCommand(new TeleopDrive());
        }

        return instance;
    }
}

