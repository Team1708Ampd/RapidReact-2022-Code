package frc.robot.subsystems.drivetrain;

public interface SwerveDrivetrainConstants {

	// Length and Width of robot in inches
	public final double L = 24.5;
	public final double W = 22.5;

	// PIDF Variables
	public final double kP = 0.0008;
	public final double kI = 0.0;
	public final double kD = 0.0001;
	public final double kF = 0.0;
	
	// Quadrature Encoder Ticks per Rotation
	public final int QUAD_COUNTS_PER_ROT = 1658;

	// Talon FX Turn Motor CAN ID
	public final int frontLeftTurnTalonID = 4;
	public final int frontRightTurnTalonID = 2;
	public final int backLeftTurnTalonID = 0;
	public final int backRightTurnTalonID = 6;

	// IDs for Drive Motors
	public final int frontLeftDriveID = 5;
	public final int frontRightDriveID = 3;
	public final int backLeftDriveID = 1;
	public final int backRightDriveID = 7;

	// Analog Encoder ID
	public final int frontLeftEncoderID = 0;
	public final int frontRightEncoderID = 3;
	public final int backLeftEncoderID = 1;
	public final int backRightEncoderID = 2;

	// Offset of analog to make encoders face forward
	public final int frontLeftEncoderOffset = 10;
	public final int frontRightEncoderOffset = 320;
	public final int backLeftEncoderOffset = 178;
	public final int backRightEncoderOffset = 3;
}