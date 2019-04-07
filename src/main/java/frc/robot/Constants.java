package frc.robot;

public class Constants {

    // Intake constants.
    public static final double INTAKE_BELT_SPEED = .5;
    public static final double OUTTAKE_BELT_SPEED = 1;
    public static final double WINDOW_MOTOR_SPEED_CLOSE = 0.5;
    public static final double WINDOW_MOTOR_SPEED_OPEN = -0.6
    ;
    public static final double PROPUP_MOTOR_SPEED = 0.8;
    
    public static final double POV_TOP_LEFT = 315;
    public static final double POV_TOP = 0;
    public static final double POV_TOP_RIGHT = 45;
    public static final double POV_BOTTOM_RIGHT = 135;
    public static final double POV_BOTTOM = 180;
    public static final double POV_BOTTOM_LEFT = 225;

    public static final double HOLD_BALL_SETPOINT = 0.3605;
    public static final double CLOSE_ARMS_SETPOINT = 0.3655;
    public static final double LATCH_HATCH_SETPOINT = 0.3632;

    public static final int INTAKE_PROP_UPPER_LIMIT = 0;
    public static final int INTAKE_PROP_LOWER_LIMIT = 450000;
    public static final int INTAKE_PROP_90 = 342800;

    public static final double ELEVATOR_SPEED_MULTIPLIER = 0.5;
    
    public static final double ELEVATOR_ENC_P = 0.004;
    public static final double ELEVATOR_ENC_I = 0;
    public static final double ELEVATOR_ENC_D = 0;

    public static final int ELEVATOR_ENC_LOW = 61000;
    public static final int ELEVATOR_ENC_MED = 147671;
    public static final int ELEVATOR_ENC_HIGH = 240000;

    public static final int ELEVATOR_ENC_LOW_HATCH = 34550;
    public static final int ELEVATOR_ENC_MED_HATCH = 115000;
    public static final int ELEVATOR_ENC_HIGH_HATCH = 216400;

    public static final int ELEVATOR_HATCH_LOADOFF = 57230;

    public static final int ELEVATOR_LOWER_LIMIT = 610;
    public static final int ELEVATOR_UPPER_LIMIT = 260000;

    public static final double ELEVATOR_STATIC_OFFSET = 0.08;

    public static final double DRIVE_MULTIPLIER = 0.6;
    public static final double AUTON_DRIVE_MULTIPLIER = 0.5;
 
    public static final double MOVE_X_FEET_GYRO_P = 0.01;
    public static final double MOVE_X_FEET_GYRO_I = 0;
    public static final double MOVE_X_FEET_GYRO_D = 0;

    public static final double MOVE_X_FEET_ENC_P = 0.02;
    public static final double MOVE_X_FEET_ENC_I = 0;
    public static final double MOVE_X_FEET_ENC_D = 0.07;

    public static final double CURVE_P = 0.02;
    public static final double CURVE_I = 0;
    public static final double CURVE_D = 0;

    public static final double TURN_X_ANGLE_P = 0.03;
    public static final double TURN_X_ANGLE_I = 0;
    public static final double TURN_X_ANGLE_D = 0.0081;
    
    public static final double TICKS_PER_INCH = 2;
  
}
