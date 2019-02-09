package frc.robot.commands.Elevator;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickElevator extends Command {

    public JoystickElevator() { requires(Robot.sElevator); }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        Robot.sElevator.setMotors(Robot.oi.getOperatorJoystick().getY());
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { }

    @Override
    protected void interrupted() { }
    
}
