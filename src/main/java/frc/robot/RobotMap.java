package frc.robot;

public class RobotMap {
    // Intake motor ports.
    public static int PROPUP_MOTOR_PORT = 0;
    public static int WINDOW_MOTOR_PORT = 1;
    public static int BELT_MOTOR_PORT = 2;

    // Intake potentiometer port
    public static int INTAKE_POT_PORT = 6;

    // Intake buttons.
    public static int OUTTAKE_BUTTON = 1;
    public static int INTAKE_BUTTON = 2;
    public static int HOLDBALL_BUTTON = 30;
    public static int CLOSE_ARMS_BUTTON = 50;
    public static int LATCHHATCH_BUTTON = 40;
    public static int LIFTPROPUP_BUTTON = 3;
    public static int DROPPROPUP_BUTTON = 4;

    // Other intake constants.
    public static double INTAKE_BELT_SPEED = .5;
    public static double OUTTAKE_BELT_SPEED = 1;
    public static double WINDOWMOTOR_SPEED_MULT = 0.7;

    //Intake Potentiometer PID values and setpoint constants
    public static double INTAKEPID_P = 0.05;
    public static double INTAKEPID_I = 0;
    public static double INTAKEPID_D = 0.07;

    public static double HOLD_BALL_SETPOINT = 100;
    public static double CLOSE_ARMS_SETPOINT = 1000;
    public static double LATCHHATCH_SETPOINT = 2000;

    // Joysticks.
    public static int OPERATOR_JOYSTICK_PORT = 0;
}
