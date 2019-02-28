package frc.robot.commands.Elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickElevator extends Command {

    public static double currentHeight = 0;

    public JoystickElevator() { requires(Robot.sElevator); }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        currentHeight += Robot.oi.getOperatorJoystick().getY();
        if (Elevator.rEncoder.get() < Constants.ELEVATOR_LOWER_LIMIT && Robot.oi.getOperatorJoystick().getY() > 0 
        || Elevator.rEncoder.get() > Constants.ELEVATOR_UPPER_LIMIT && Robot.oi.getOperatorJoystick().getY() < 0) {
            Robot.sElevator.setMotors(0);
        } else {
            Robot.sElevator.setMotors(Robot.oi.getOperatorJoystick().getY());
        }
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { }

    @Override
    protected void interrupted() { }
    
}
