package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI {

    // Declare joysticks/buttons.
    private Joystick operatorJoystick;

    private JoystickButton intakeButton;
    private JoystickButton outtakeButton;
    private JoystickButton holdBallButton;
    private JoystickButton closeArmsButton;
    private JoystickButton latchHatchButton;
    private JoystickButton liftPropupButton;
    private JoystickButton dropPropupButton;

    public OI() {
        // Initialize joysticks/buttons.
        operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK_PORT);

        outtakeButton = new JoystickButton(operatorJoystick, RobotMap.OUTTAKE_BUTTON);
        intakeButton = new JoystickButton(operatorJoystick, RobotMap.INTAKE_BUTTON);
        holdBallButton = new JoystickButton(operatorJoystick, RobotMap.HOLD_BALL_BUTTON);
        closeArmsButton = new JoystickButton(operatorJoystick, RobotMap.CLOSE_ARMS_BUTTON);
        latchHatchButton = new JoystickButton(operatorJoystick, RobotMap.LATCH_HATCH_BUTTON);
        liftPropupButton = new JoystickButton(operatorJoystick, RobotMap.LIFT_PROPUP_BUTTON);
        dropPropupButton = new JoystickButton(operatorJoystick, RobotMap.DROP_PROPUP_BUTTON);

        // Button actions.
        outtakeButton.whileHeld(new OuttakeCommand());
        intakeButton.whileHeld(new IntakeCommand());
        holdBallButton.toggleWhenPressed(new HoldBallCommand());        
        closeArmsButton.whenPressed(new BringArmsTogetherCommand());
        latchHatchButton.toggleWhenPressed(new LatchHatchCommand());
        liftPropupButton.whileHeld(new LiftPropupCommand());
        dropPropupButton.whileHeld(new DropPropupCommand());
    }

    public Joystick getOperatorJoystick() { return operatorJoystick; }
    
}
