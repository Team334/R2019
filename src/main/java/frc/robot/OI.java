package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.SetElevatorHeight;

public class OI {
    // Make joystick.
    public static Joystick thrustMaster;

    private Button elevatorLow;
    private Button elevatorMed;
    private Button elevatorHigh;

    public OI() {

        // Initialize buttons.
        elevatorLow = new JoystickButton(thrustMaster, 14);
        elevatorMed = new JoystickButton(thrustMaster, 15);
        elevatorHigh = new JoystickButton(thrustMaster, 16);

        // Make button actions.
        elevatorLow.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_LOW));
        elevatorMed.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_MED));
        elevatorHigh.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_HIGH));

    }
}
