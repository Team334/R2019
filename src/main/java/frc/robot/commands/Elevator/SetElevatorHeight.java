package frc.robot.commands.Elevator;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class SetElevatorHeight extends Command {
    
    private double height;

    public SetElevatorHeight(double height) {
        requires(Robot.sElevator);
        this.height = height;
    }

    @Override
    protected void initialize() {
        Robot.sElevator.setSetpoint(height);
        Robot.sElevator.enable();
    }

    @Override
    protected void execute() { }

    @Override
    protected boolean isFinished() {
        return Robot.sElevator.onTarget() || Robot.oi.getOperatorJoystick().getRawButton(RobotMap.ELEVATOR_OVERRIDE);
    }

    @Override
    protected void end() {
        Robot.sElevator.stop();
        Robot.sElevator.disable();
    }

    @Override
    protected void interrupted() {
        Robot.sElevator.stop();
        Robot.sElevator.disable();
    }
    
}
