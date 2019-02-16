package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class HoldBallCommand extends Command {

    public HoldBallCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {
        // Sets up the pid so it closes on the ball and applies pressure onto it.
        Robot.sIntake.setSetpoint(Constants.HOLD_BALL_SETPOINT);
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
    protected boolean isFinished() { return false; }

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
