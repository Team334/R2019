package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI {
    // Declare joysticks/buttons.
    Joystick operatorJoystick;

    JoystickButton openIntakeButton;
    JoystickButton closeIntakeButton;
    JoystickButton holdBallButton;
    JoystickButton closeArmsButton;
    JoystickButton latchHatchButton;

    public OI() {
        // Initialize joysticks/buttons.
        operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK_PORT);

        openIntakeButton = new JoystickButton(operatorJoystick, RobotMap.OPENINTAKE_BUTTON);
        closeIntakeButton = new JoystickButton(operatorJoystick, RobotMap.CLOSEINTAKE_BUTTON);
        holdBallButton = new JoystickButton(operatorJoystick, RobotMap.HOLDBALL_BUTTON);
        closeArmsButton = new JoystickButton(operatorJoystick, RobotMap.CLOSE_ARMS_BUTTON);
        latchHatchButton = new JoystickButton(operatorJoystick, RobotMap.LATCHHATCH_BUTTON);

        // Button actions.
        openIntakeButton.whileHeld(new IntakeCommand());
        closeIntakeButton.whileHeld(new OuttakeCommand());
        holdBallButton.toggleWhenPressed(new HoldBallCommand());        
        closeArmsButton.whenPressed(new BringArmsTogetherCommand());
        latchHatchButton.toggleWhenPressed(new LatchHatchCommand());
    }

    public Joystick getOperatorJoystick() { return operatorJoystick; }
}
