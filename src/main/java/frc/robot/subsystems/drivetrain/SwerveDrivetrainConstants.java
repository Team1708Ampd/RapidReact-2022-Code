package frc.robot.subsystems.drivetrain;

public interface SwerveDrivetrainConstants {

	// Length and Width of robot in inches
	public final double L = 24.5;
	public final double W = 21.1;

	// PIDF FRONT RIGHT - NO TOUCHIE
	public final double kPFR = 0.008;
	public final double kIFR = 0.00005;
	public final double kDFR = 0.000000;
	public final double kFFR = 0.0;
	
	// PIDF FRONT LEFT - NO TOUCHIE
	public final double kPFL = 0.009;
	public final double kIFL = 0.0001;
	public final double kDFL = 0.000001;
	public final double kFFL = 0.0;

	// PIDF BACK LEFT
	public final double kPBL = 0.008;
	public final double kIBL = 0.00005;
	public final double kDBL = 0.00000;
	public final double kFBL = 0.0;

	// PIDF BACK RIGHT

	public final double kPBR = 0.007;
	public final double kIBR = 0.00003;
	public final double kDBR = 0.0000;
	public final double kFBR = 0.0;

	
	// Quadrature Encoder Ticks per Rotation
	public final int QUAD_COUNTS_PER_ROT = 1658;

	// Talon FX Turn Motor CAN ID
	public final int frontLeftTurnTalonID = 5;
	public final int frontRightTurnTalonID = 2;
	public final int backLeftTurnTalonID = 0;
	public final int backRightTurnTalonID = 6;

	// IDs for Drive Motors
	public final int frontLeftDriveID = 4;
	public final int frontRightDriveID = 3;
	public final int backLeftDriveID = 1;
	public final int backRightDriveID = 7;

	// Analog Encoder ID
	public final int frontLeftEncoderID = 0;
	public final int frontRightEncoderID = 3;
	public final int backLeftEncoderID = 1;
	public final int backRightEncoderID = 2;

	// Offset of analog to make encoders face forward
	public final int frontLeftEncoderOffset =  -115;
	public final int frontRightEncoderOffset = -90;
	public final int backLeftEncoderOffset =   0;
	public final int backRightEncoderOffset =  0;
}