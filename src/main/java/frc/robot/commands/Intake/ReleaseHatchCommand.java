package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class ReleaseHatchCommand extends Command {
    
    public ReleaseHatchCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {
        // Sets up the pid so it opens the arms and holds the hatch with a bit of pressure.
        Robot.sIntake.setSetpoint(Constants.CLOSE_ARMS_SETPOINT);
        Robot.sIntake.setAbsoluteTolerance(0);
        Robot.sIntake.setOutputRange(-0.4, 0.4);

        Robot.sIntake.enable();
    }

    @Override
    protected void execute() { }

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
