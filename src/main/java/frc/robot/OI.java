package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CloseIntakeCommand;
import frc.robot.commands.OpenIntakeCommand;

public class OI {
    // Declare joysticks/buttons.
    Joystick operatorJoystick;

    JoystickButton openIntakeButton;
    JoystickButton closeIntakeButton;

    public OI() {
        // Initialize joysticks/buttons.
        operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK_PORT);

        openIntakeButton = new JoystickButton(operatorJoystick, RobotMap.OPENINTAKE_BUTTON);
        closeIntakeButton = new JoystickButton(operatorJoystick, RobotMap.CLOSEINTAKE_BUTTON);

        // Button actions.
        openIntakeButton.whileHeld(new OpenIntakeCommand());
        closeIntakeButton.whileHeld(new CloseIntakeCommand());
    }

    public Joystick getOperatorJoystick() { return operatorJoystick; }
}
