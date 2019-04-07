package frc.robot.commands.Elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickElevator extends Command {

    public JoystickElevator() { requires(Robot.sElevator); }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        if (Elevator.rEncoder.get() > Constants.ELEVATOR_UPPER_LIMIT && Robot.oi.getOperatorJoystick().getY() < 0) {
            Robot.sElevator.setMotors(0);
            
        } else {
            Robot.sElevator.setMotors(Robot.oi.getOperatorJoystick().getY() * Constants.ELEVATOR_SPEED_MULTIPLIER);
        }
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { }

    @Override
    protected void interrupted() { }
    
}
