package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftPropupCommand extends Command {
    public LiftPropupCommand() {
    
    }

  
    @Override
    protected void initialize() {
    
    }

    @Override
    protected void execute() {
        // Sets speed to raise intake.
        Robot.sIntake.setPropupMotor(0.7);
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { Robot.sIntake.setPropupMotor(0); }

    @Override
    protected void interrupted() { Robot.sIntake.setPropupMotor(0); }
}
