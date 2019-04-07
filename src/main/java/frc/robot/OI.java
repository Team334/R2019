package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
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
    private JoystickButton closeArmButton;
    private JoystickButton openArmButton;

    private JoystickButton elevatorLowCargo;
    private JoystickButton elevatorMedCargo;
    private JoystickButton elevatorHighCargo;
    private JoystickButton elevatorLowHatch;
    private JoystickButton elevatorMedHatch;
    private JoystickButton elevatorHighHatch;
    private JoystickButton elevatorHatchLoadoff;
    private JoystickButton elevatorOverride; // Utilized in SetElevatorHeight.java

    public static JoystickButton autonOverride;

    public OI() {
        // Initialize joysticks/buttons.
        operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK_PORT);
        leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
        rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);

        outtakeButton = new JoystickButton(operatorJoystick, RobotMap.OUTTAKE_BUTTON);
        intakeButton = new JoystickButton(operatorJoystick, RobotMap.INTAKE_BUTTON);
        holdBallButton = new JoystickButton(operatorJoystick, RobotMap.HOLD_BALL_BUTTON);
        closeArmButton = new JoystickButton(operatorJoystick, RobotMap.OPEN_ARM_BUTTON);
        openArmButton = new JoystickButton(operatorJoystick, RobotMap.CLOSE_ARM_BUTTON);
        
        elevatorLowCargo = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_LOW_CARGO);
        elevatorMedCargo = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_MED_CARGO);
        elevatorHighCargo = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_HIGH_CARGO);
        elevatorLowHatch = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_LOW_HATCH);
        elevatorMedHatch = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_MED_HATCH);
        elevatorHighHatch = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_BUTTON_HIGH_HATCH);   
        elevatorHatchLoadoff = new JoystickButton(operatorJoystick, RobotMap.HATCH_LOADOFF);
        elevatorOverride = new JoystickButton(operatorJoystick, RobotMap.ELEVATOR_OVERRIDE);

        autonOverride = new JoystickButton(leftJoystick, 1);

        // Button actions.
        outtakeButton.whileHeld(new OuttakeCommand());
        intakeButton.whileHeld(new IntakeCommand());
        holdBallButton.toggleWhenPressed(new HoldBallCommand());

        elevatorLowCargo.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW));
        elevatorMedCargo.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_MED));
        elevatorHighCargo.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_HIGH));
        elevatorLowHatch.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW_HATCH));
        elevatorMedHatch.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_MED_HATCH));
        elevatorHighHatch.whenPressed(new SetElevatorHeight(Constants.ELEVATOR_ENC_HIGH_HATCH));
        elevatorHatchLoadoff.whenActive(new SetElevatorHeight(Constants.ELEVATOR_HATCH_LOADOFF));
    }
  
    public Joystick getRightJoystick() { return rightJoystick; }
  
    public Joystick getLeftJoystick() { return leftJoystick; }

    public Joystick getOperatorJoystick() { return operatorJoystick; }

    public double getOperatorPOV() { return operatorJoystick.getPOV(); }
    
    public boolean getCloseArmButton() { return closeArmButton.get(); }

    public boolean getOpenArmButton() { return openArmButton.get(); }

}
