package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class BringArmsTogetherCommand extends Command {
    
    public BringArmsTogetherCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {
        // Sets up the pid so it closes the arms entirely so a hatch can be taken.
        Robot.sIntake.setSetpoint(Constants.CLOSE_ARMS_SETPOINT);
        Robot.sIntake.setAbsoluteTolerance(Constants.INTAKE_PID_TOLERANCE);
        Robot.sIntake.setOutputRange(Constants.INTAKE_PID_RANGE_LOWER, Constants.INTAKE_PID_RANGE_UPPER);

        Robot.sIntake.enable();
    }

    @Override
    protected void execute() {
        // Sets motor speed to the PID output.
        Robot.sIntake.setWindowMotor(Robot.sIntake.intakePIDOutput);
    }

    @Override
    protected boolean isFinished() {
        // Ends the command once the arms are fully closed.
        return Robot.sIntake.onTarget();
    }

    @Override
    protected void end() {
        // Turns the pid off and stops the motor.
        Robot.sIntake.disable();
        Robot.sIntake.setWindowMotor(0);
    }

    @Override
    protected void interrupted() {
        Robot.sIntake.disable();
        Robot.sIntake.setWindowMotor(0);
    }
    
}
