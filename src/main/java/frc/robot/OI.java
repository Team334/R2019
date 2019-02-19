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
    private JoystickButton armsTogetherButton;
    private JoystickButton latchHatchButton;
    private JoystickButton openArmButton;
    private JoystickButton closeArmButton;

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
        // armsTogetherButton = new JoystickButton(operatorJoystick, RobotMap.ARMS_TOGETHER_BUTTON);
        latchHatchButton = new JoystickButton(operatorJoystick, RobotMap.LATCH_HATCH_BUTTON);
        openArmButton = new JoystickButton(operatorJoystick, RobotMap.OPEN_ARM_BUTTON);
        closeArmButton = new JoystickButton(operatorJoystick, RobotMap.CLOSE_ARM_BUTTON);
        elevatorLow = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_LOW);
        elevatorMed = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_MED);
        elevatorHigh = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_HIGH);

        // Button actions.
        outtakeButton.whileHeld(new OuttakeCommand());
        intakeButton.whileHeld(new IntakeCommand());
        holdBallButton.toggleWhenPressed(new HoldBallCommand());        
        // armsTogetherButton.whenPressed(new BringArmsTogetherCommand());
        latchHatchButton.toggleWhenPressed(new LatchHatchCommand());
        elevatorLow.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW));
        elevatorMed.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_MED));
        elevatorHigh.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_HIGH));
    }
  
    public Joystick getRightJoystick() { return rightJoystick; }
  
    public Joystick getLeftJoystick() { return leftJoystick; }

    public Joystick getOperatorJoystick() { return operatorJoystick; }

    public double getOperatorPOV() { return operatorJoystick.getPOV(); }
    
    public boolean getOpenArmButton() { return openArmButton.get(); }

    public boolean getCloseArmButton() { return closeArmButton.get(); }

}
