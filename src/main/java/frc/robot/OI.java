package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Elevator.*;
import frc.robot.commands.Intake.*;

public class OI {

    // Declare joysticks/buttons.
    private Joystick operatorJoystick;
    private Joystick leftJoystick;
    private Joystick rightJoystick;

    private JoystickButton intakeButton;
    private JoystickButton outtakeButton;
    private JoystickButton holdBallButton;
    private JoystickButton closeArmsButton;
    private JoystickButton latchHatchButton;
    private JoystickButton liftPropupButton;
    private JoystickButton dropPropupButton;

    private Button elevatorLow;
    private Button elevatorMed;
    private Button elevatorHigh;

    public OI() {
        // Initialize joysticks/buttons.
        operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK_PORT);
        leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
        rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);

        outtakeButton = new JoystickButton(operatorJoystick, RobotMap.OUTTAKE_BUTTON);
        intakeButton = new JoystickButton(operatorJoystick, RobotMap.INTAKE_BUTTON);
        holdBallButton = new JoystickButton(operatorJoystick, RobotMap.HOLD_BALL_BUTTON);
        closeArmsButton = new JoystickButton(operatorJoystick, RobotMap.CLOSE_ARMS_BUTTON);
        latchHatchButton = new JoystickButton(operatorJoystick, RobotMap.LATCH_HATCH_BUTTON);
        liftPropupButton = new JoystickButton(operatorJoystick, RobotMap.LIFT_PROPUP_BUTTON);
        dropPropupButton = new JoystickButton(operatorJoystick, RobotMap.DROP_PROPUP_BUTTON);
        elevatorLow = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_LOW);
        elevatorMed = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_MED);
        elevatorHigh = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_HIGH);

        // Button actions.
        outtakeButton.whileHeld(new OuttakeCommand());
        intakeButton.whileHeld(new IntakeCommand());
        holdBallButton.toggleWhenPressed(new HoldBallCommand());        
        closeArmsButton.whenPressed(new BringArmsTogetherCommand());
        latchHatchButton.toggleWhenPressed(new LatchHatchCommand());
        liftPropupButton.whileHeld(new LiftPropupCommand());
        dropPropupButton.whileHeld(new DropPropupCommand());
        elevatorLow.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW));
        elevatorMed.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_MED));
        elevatorHigh.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_HIGH));
    }
  
    public Joystick getRightJoystick() { return rightJoystick; }
  
    public Joystick getLeftJoystick() { return leftJoystick; }

    public Joystick getOperatorJoystick() { return operatorJoystick; }

}
