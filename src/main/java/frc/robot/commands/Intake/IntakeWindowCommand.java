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
        if (Robot.oi.openArmButton.get()) {
            Robot.sIntake.setWindowMotor(-Constants.WINDOW_MOTOR_SPEED);
        } else if (Robot.oi.closeArmButton.get()) {
            Robot.sIntake.setWindowMotor(Constants.WINDOW_MOTOR_SPEED);
        } 

        // Uses POV of joystick to control propup and limits movement based on encoder.
        if (Robot.sIntake.getEncoderValue() < Constants.PROPUP_LOWER_LIMIT && 
        (Robot.oi.getOperatorPOV() == Constants.POV_TOP_LEFT || Robot.oi.getOperatorPOV() == Constants.POV_TOP || Robot.oi.getOperatorPOV() == Constants.POV_TOP_RIGHT)) {
            Robot.sIntake.setPropupMotor(Constants.PROPUP_MOTOR_SPEED);
        } else if (Robot.sIntake.getEncoderValue() > Constants.PROPUP_UPPER_LIMIT && 
        (Robot.oi.getOperatorPOV() == Constants.POV_BOTTOM_RIGHT || Robot.oi.getOperatorPOV() == Constants.POV_BOTTOM || Robot.oi.getOperatorPOV() == Constants.POV_BOTTOM_LEFT)) {
            Robot.sIntake.setPropupMotor(-Constants.PROPUP_MOTOR_SPEED);
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
