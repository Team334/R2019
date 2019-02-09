package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class HoldBallCommand extends Command {

    public HoldBallCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {
        // Sets up the pid so it closes on the ball and applies pressure onto it.
        Robot.sIntake.intakePID.reset();
        Robot.sIntake.intakePID.setSetpoint(Constants.HOLD_BALL_SETPOINT);
        Robot.sIntake.intakePID.setAbsoluteTolerance(Constants.INTAKE_PID_TOLERANCE);
        Robot.sIntake.intakePID.setOutputRange(Constants.INTAKE_PID_RANGE_LOWER, Constants.INTAKE_PID_RANGE_UPPER);

        Robot.sIntake.intakePID.enable();
    }

    @Override
    protected void execute() {
        // Sets motor speed to the PID output.
        Robot.sIntake.setWindowMotor(Robot.sIntake.intakePID.get());
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() {
        // Turns the pid off and stops the motor.
        Robot.sIntake.intakePID.disable();
        Robot.sIntake.setWindowMotor(0);
    }

    @Override
    protected void interrupted() {
        Robot.sIntake.intakePID.disable();
        Robot.sIntake.setWindowMotor(0);
    }
    
}
