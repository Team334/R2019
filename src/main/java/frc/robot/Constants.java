package frc.robot;

public class Constants {

    // Intake constants.
    public static final double INTAKE_BELT_SPEED = .5;
    public static final double OUTTAKE_BELT_SPEED = 1;
    public static final double WINDOW_MOTOR_SPEED = 0.7;
    public static final double PROPUP_MOTOR_SPEED = 0.8;
    public static final double PROPUP_UPPER_LIMIT = -1;
    public static final double PROPUP_LOWER_LIMIT = -1;
    
    public static final double POV_TOP_LEFT = 315;
    public static final double POV_TOP = 0;
    public static final double POV_TOP_RIGHT = 45;
    public static final double POV_BOTTOM_RIGHT = 135;
    public static final double POV_BOTTOM = 180;
    public static final double POV_BOTTOM_LEFT = 225;

    // Intake Potentiometer PID values and setpoint constants.
    public static final double INTAKE_PID_P = 0;
    public static final double INTAKE_PID_I = 0;
    public static final double INTAKE_PID_D = 0;   

    public static final double HOLD_BALL_SETPOINT = -1;
    public static final double CLOSE_ARMS_SETPOINT = -1;
    public static final double LATCH_HATCH_SETPOINT = -1;

    public static final double INTAKE_PID_TOLERANCE = -1;
    public static final double INTAKE_PID_RANGE_LOWER = 0.4;
    public static final double INTAKE_PID_RANGE_UPPER = -0.4;
    
    public static final double ELEVATOR_ENC_P = 0;
    public static final double ELEVATOR_ENC_I = 0;
    public static final double ELEVATOR_ENC_D = 0;

    public static final int ELEVATOR_ENC_LOW = -1;
    public static final int ELEVATOR_ENC_MED = -1;
    public static final int ELEVATOR_ENC_HIGH = -1;
    public static final int ELEVATOR_ENC_CARGO = -1;

    public static final double ELEVATOR_STATIC_OFFSET = 0.06;

    public static final double DRIVE_MULTIPLIER = 0.3;
 
    public static final double MOVE_X_FEET_GYRO_P = 0;
    public static final double MOVE_X_FEET_GYRO_I = 0;
    public static final double MOVE_X_FEET_GYRO_D = 0;

    public static final double MOVE_X_FEET_ENC_P = 0;
    public static final double MOVE_X_FEET_ENC_I = 0;
    public static final double MOVE_X_FEET_ENC_D = 0;

    public static final double TURN_P = 0;
    public static final double TURN_I = 0;
    public static final double TURN_D = 0;

    public static final double TURN_X_ANGLE_P = 0;
    public static final double TURN_X_ANGLE_I = 0;
    public static final double TURN_X_ANGLE_D = 0;
  
}
