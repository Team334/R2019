package frc.robot;

public class RobotMap {

    // Intake motor ports.
    public static final int PROPUP_MOTOR_PORT = 0;
    public static final int WINDOW_MOTOR_PORT = 1;
    public static final int BELT_MOTOR_PORT = 2;

    // Intake potentiometer port
    public static final int INTAKE_POT_PORT = 6;

    // Intake buttons.
    public static final int OUTTAKE_BUTTON = 1;
    public static final int INTAKE_BUTTON = 2;
    public static final int HOLDBALL_BUTTON = 30;
    public static final int CLOSE_ARMS_BUTTON = 50;
    public static final int LATCHHATCH_BUTTON = 40;
    public static final int LIFTPROPUP_BUTTON = 3;
    public static final int DROPPROPUP_BUTTON = 4;

    // Other intake constants.
    public static final double INTAKE_BELT_SPEED = .5;
    public static final double OUTTAKE_BELT_SPEED = 1;
    public static final double WINDOWMOTOR_SPEED_MULT = 0.7;

    //Intake Potentiometer PID values and setpoint constants
    public static final double INTAKEPID_P = 0.05;
    public static final double INTAKEPID_I = 0;
    public static final double INTAKEPID_D = 0.07;

    public static final double HOLD_BALL_SETPOINT = 100;
    public static final double CLOSE_ARMS_SETPOINT = 1000;
    public static final double LATCHHATCH_SETPOINT = 2000;

    // Joysticks.
    public static final int OPERATOR_JOYSTICK_PORT = 0;
    
}
