package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class SwerveWheelDrive {

	public enum SwerveWheelDriveType { TalonSRX, Spark, VictorSPX, TalonFX }

	SwerveWheelDriveType type;

	MotorController controller;

	public SwerveWheelDrive(SwerveWheelDriveType type, int id, boolean inverted) {
		if (type == SwerveWheelDriveType.TalonSRX) {

			// Create TalonSRX object with the ID from the constructor
			WPI_TalonSRX drive = new WPI_TalonSRX(id);			

			drive.configFactoryDefault();

			// Invert the motor depending on the inverted value
			drive.setInverted(inverted);

			// WPI_TalonSRX can be passed into many different WPILib objects like the
			// SpeedController
			controller = drive;

		} else if (type == SwerveWheelDriveType.Spark) {

			// Create Spark object with the ID from the constructor
			Spark drive = new Spark(id);

			// Invert the motor depending on the inverted value
			drive.setInverted(inverted);

			// Spark is a WPILib object so it can be passed into many different WPILib objects like
			// the SpeedController
			controller = drive;

		} else if (type == SwerveWheelDriveType.VictorSPX) {

			// Create VictorSPX object with the ID from the constructor
			WPI_VictorSPX drive = new WPI_VictorSPX(id);

			drive.configFactoryDefault();

			// Invert the motor depending on the inverted value
			drive.setInverted(inverted);

			// WPI_VictorSPX can be passed into many different WPILib objects like the
			// SpeedController
			controller = drive;
		} else if (type == SwerveWheelDriveType.TalonFX) {

			// Create TalonFX object with the ID from the constructor
			WPI_TalonFX drive = new WPI_TalonFX(id);

			updateStatusFrames(drive);

			drive.configFactoryDefault();

			// Invert the motor depending on the inverted value
			drive.setInverted(inverted);

			controller = drive;
		}
	}

	public void setSpeed(double speed) {
		controller.set(speed);
	}

	private void updateStatusFrames(WPI_TalonFX motor)
    {
        motor.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 255);       
        motor.setStatusFramePeriod(StatusFrame.Status_10_MotionMagic, 255);        
        motor.setStatusFramePeriod(StatusFrame.Status_4_AinTempVbat, 255);      
        motor.setStatusFramePeriod(StatusFrame.Status_6_Misc, 255);     
        motor.setStatusFramePeriod(StatusFrame.Status_10_Targets, 255);        
        motor.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 255);        
        motor.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 255);      
    }
}
