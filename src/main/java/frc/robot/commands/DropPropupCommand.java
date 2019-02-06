package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DropPropupCommand extends Command {
    
    public DropPropupCommand() {
        // Doesn't require anything so it can't interrupt the intake window command.
    }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        // Sets speed to lower the intake.
        Robot.sIntake.setPropupMotor(-0.7);
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { Robot.sIntake.setPropupMotor(0); }

    @Override
    protected void interrupted() { Robot.sIntake.setPropupMotor(0); }
    
}
