package frc.robot.subsystems.drivetrain;

public interface SwerveDrivetrainConstants {

	// Length and Width of robot in inches
	public final double L = 25;
	public final double W = 23;

	// PIDF Variables
	public final double kP = 0.02;
	public final double kI = 0.0;
	public final double kD = 0.0;
	public final double kF = 0.0;
	
	// Quadrature Encoder Ticks per Rotation
	public final int QUAD_COUNTS_PER_ROT = 1658;

	// Talon FX Turn Motor CAN ID
	public final int frontLeftTurnTalonID = 0;
	public final int frontRightTurnTalonID = 3;
	public final int backLeftTurnTalonID = 1;
	public final int backRightTurnTalonID = 2;

	// IDs for Drive Motors
	public final int frontLeftDriveID = 5;
	public final int frontRightDriveID = 3;
	public final int backLeftDriveID = 1;
	public final int backRightDriveID = 7;

	// Analog Encoder ID
	public final int frontLeftEncoderID = 4;
	public final int frontRightEncoderID = 2;
	public final int backLeftEncoderID = 0;
	public final int backRightEncoderID = 6;

	// Offset of analog to make encoders face forward
	public final int frontLeftEncoderOffset = 0;
	public final int frontRightEncoderOffset = 0;
	public final int backLeftEncoderOffset = 0;
	public final int backRightEncoderOffset = 0;
}