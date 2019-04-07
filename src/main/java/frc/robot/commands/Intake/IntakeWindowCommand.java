package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeWindowCommand extends Command {
    
    public IntakeWindowCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        // Speed of the window motor is set according to buttons.
        if (Robot.oi.getCloseArmButton()) {
            Robot.sIntake.setWindowMotor(Constants.WINDOW_MOTOR_SPEED_CLOSE);
        } else if (Robot.oi.getOpenArmButton()) {
            Robot.sIntake.setWindowMotor(Constants.WINDOW_MOTOR_SPEED_OPEN);
        } else {
            Robot.sIntake.setWindowMotor(0);
        }

        // Uses POV of joystick to control propup and limits movement based on encoder.
        if (Robot.oi.getOperatorPOV() == Constants.POV_TOP_LEFT || Robot.oi.getOperatorPOV() == Constants.POV_TOP || Robot.oi.getOperatorPOV() == Constants.POV_TOP_RIGHT) {
            Robot.sIntake.setPropupMotor(-Constants.PROPUP_MOTOR_SPEED);
        } else if (Robot.sIntake.getEncoderValue() < Constants.INTAKE_PROP_LOWER_LIMIT && 
        (Robot.oi.getOperatorPOV() == Constants.POV_BOTTOM_RIGHT || Robot.oi.getOperatorPOV() == Constants.POV_BOTTOM || Robot.oi.getOperatorPOV() == Constants.POV_BOTTOM_LEFT)) {
            Robot.sIntake.setPropupMotor(Constants.PROPUP_MOTOR_SPEED);
        } else {
            Robot.sIntake.setPropupMotor(0);
        }
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { 
        Robot.sIntake.setPropupMotor(0); 
        Robot.sIntake.setWindowMotor(0);
    }

    @Override
    protected void interrupted() { 
        Robot.sIntake.setPropupMotor(0); 
        Robot.sIntake.setWindowMotor(0);
    }
    
}
