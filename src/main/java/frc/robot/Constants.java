package frc.robot;

public class Constants {

    // Other intake constants.
    public static final double INTAKE_BELT_SPEED = .5;
    public static final double OUTTAKE_BELT_SPEED = 1;
    public static final double WINDOW_MOTOR_SPEED_MULT = 0.7;
    public static final double PROPUP_MOTOR_SPEED_MULT = 0.8;

    //Intake Potentiometer PID values and setpoint constants
    public static final double INTAKE_PID_P = 0.05;
    public static final double INTAKE_PID_I = 0;
    public static final double INTAKE_PID_D = 0.07;

    public static final double HOLD_BALL_SETPOINT = 100;
    public static final double CLOSE_ARMS_SETPOINT = 1000;
    public static final double LATCH_HATCH_SETPOINT = 2000;

    public static final double INTAKE_PID_TOLERANCE = 1;
    public static final double[] INTAKE_PID_RANGE = {-0.5, 0.5};
    
}