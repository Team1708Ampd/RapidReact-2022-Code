package frc.robot.subsystems.drivetrain;

public interface SwerveDrivetrainConstants {

	// Length and Width of robot in inches
	public final double L = 24.5;
	public final double W = 21.1;

	// // PIDF FRONT RIGHT - DO NOT CHANGE
	// public final double kPFR = 0.006;
	// public final double kIFR = 0.000002;
	// public final double kDFR = 0.0000;
	// public final double kFFR = 0.0;
	
	// // PIDF FRONT LEFT - DO NOT CHANGE
	// public final double kPFL = 0.0055;
	// public final double kIFL = 0.00001;
	// public final double kDFL = 0.00256;
	// public final double kFFL = 0.0;

	// // PIDF BACK LEFT - DO NOT CHANGE
	// public final double kPBL = 0.006;
	// public final double kIBL = 0.000004;
	// public final double kDBL = 0.00256;
	// public final double kFBL = 0.0;

	// // PIDF BACK RIGHT - DO NOT CHANGE
	// public final double kPBR = 0.006;
	// public final double kIBR = 0.000002;
	// public final double kDBR = 0.00128;
	// public final double kFBR = 0.0;

	// PIDF FRONT RIGHT - DO NOT CHANGE
	public final double kPFR = 0.0065;
	public final double kIFR = 0.000008;
	public final double kDFR = 0.00300;
	public final double kFFR = 0.0;
	
	// PIDF FRONT LEFT - DO NOT CHANGE
	public final double kPFL = 0.0065;
	public final double kIFL = 0.000008;
	public final double kDFL = 0.00256;
	public final double kFFL = 0.0;

	// PIDF BACK LEFT - DO NOT CHANGE
	public final double kPBL = 0.0065;
	public final double kIBL = 0.000008;
	public final double kDBL = 0.00256;
	public final double kFBL = 0.0;

	// PIDF BACK RIGHT - DO NOT CHANGE
	public final double kPBR = 0.006;
	public final double kIBR = 0.000008;
	public final double kDBR = 0.00128;
	public final double kFBR = 0.0;

	// Scaling ratio for geared motor gear ration
	public final double motorOutputScaleRatio = 6.3;
	
	// Integrated Encoder Ticks per Rotation
	public final int INT_COUNTS_PER_ROT = 2048;

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
	public final int frontLeftEncoderOffset =  -100;
	public final int frontRightEncoderOffset = 45;
	public final int backLeftEncoderOffset =   5;
	public final int backRightEncoderOffset =  135;
}