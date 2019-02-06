package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class CollapseElevatorCommand extends Command {

    public CollapseElevatorCommand() {
        requires(Robot.sElevator);
    }

    @Override
    protected void initialize() {
        System.out.println("COLLAPSING ELEVATOR");

        Robot.sElevator.setSetpoint(Constants.ELEVATOR_ENC_LOW);
        Robot.sElevator.enable();
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return Robot.sElevator.onTarget();
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
