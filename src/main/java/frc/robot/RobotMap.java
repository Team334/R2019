package frc.robot;

public class RobotMap {
    // Intake motor ports.
    public static int WINDOW_MOTOR_PORT = 0;
    public static int LEFTBELT_MOTOR_PORT = 1;
    public static int RIGHTBELT_MOTOR_PORT = 2;

    // Intake potentiometer port
    public static int INTAKE_POT_PORT = 6;

    // Intake buttons.
    public static int OPENINTAKE_BUTTON = 3;
    public static int CLOSEINTAKE_BUTTON = 4;
    public static int HOLDBALL_BUTTON = 5;
    public static int CLOSE_ARMS_BUTTON = 6;
    public static int LATCHHATCH_BUTTON = 7;

    // Other intake constants.
    public static double INTAKE_BELT_SPEED = 0.5;
    public static double WINDOWMOTOR_SPEED_MULT = 0.5;

    //Intake Potentiometer PID values and setpoint constants
    public static double INTAKEPID_P = 0;
    public static double INTAKEPID_I = 0;
    public static double INTAKEPID_D = 0;

    public static double HOLD_BALL_SETPOINT = 100;
    public static double CLOSE_ARMS_SETPOINT = 1000;
    public static double LATCHHATCH_SETPOINT = 2000;

    // Joysticks.
    public static int OPERATOR_JOYSTICK_PORT = 2;
}
