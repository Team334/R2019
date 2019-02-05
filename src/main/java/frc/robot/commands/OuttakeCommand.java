package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class OuttakeCommand extends Command {
    public OuttakeCommand() {
        // Doesn't require anything so it can't interrupt the intake window command.
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() { Robot.sIntake.setBeltMotors(-RobotMap.OUTTAKE_BELT_SPEED); }

    @Override
    protected boolean isFinished() { return false; }
    
    @Override
    protected void end() { Robot.sIntake.setBeltMotors(0); }

    @Override
    protected void interrupted() { Robot.sIntake.setBeltMotors(0); }
}