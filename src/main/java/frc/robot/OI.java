package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Elevator.*;

public class OI {

    // Make joystick.
    public static Joystick operator;

    private Button elevatorLow;
    private Button elevatorMed;
    private Button elevatorHigh;
  
    private Joystick leftJoystick;
    private Joystick rightJoystick;

    public OI() {
        // Initialize buttons.
        elevatorLow = new JoystickButton(operator, RobotMap.ELEVATOR_BUTTON_LOW);
        elevatorMed = new JoystickButton(operator, RobotMap.ELEVATOR_BUTTON_MED);
        elevatorHigh = new JoystickButton(operator, RobotMap.ELEVATOR_BUTTON_HIGH);

        // Make button actions.
        elevatorLow.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW));
        elevatorMed.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_MED));
        elevatorHigh.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_HIGH));
      
        leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
        rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
    }
  
    public Joystick getRightJoystick() { return rightJoystick; }
  
    public Joystick getLeftJoystick() { return leftJoystick; }

}
