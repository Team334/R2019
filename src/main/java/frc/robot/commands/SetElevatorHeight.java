package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetElevatorHeight extends Command {
    private double height;

    public SetElevatorHeight(double height) {
        requires(Robot.sElevator);

        this.height = height;
    }

    @Override
    protected void initialize() {
        System.out.println("MOVING ELEVATOR TO HEIGHT");

        Robot.sElevator.setSetpoint(height);
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
