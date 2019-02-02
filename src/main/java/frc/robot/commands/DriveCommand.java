package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveCommand extends Command {
    public DriveCommand() {
        requires(Robot.sDrive);
    }

    @Override
    protected void initialize() {
        System.out.println("TANK DRIVE INITIALIZED");
    }

    @Override
    protected void execute() {
        Robot.sDrive.setLeft(OI.leftJoystick.getY());
        Robot.sDrive.setRight(OI.rightJoystick.getY());
    }

    @Override
    protected boolean isFinished() {
    return false;
    }

    @Override
    protected void end() {
        System.out.println("STOPPED TANK DRIVE");
        Robot.sDrive.stop();
    }

    @Override
    protected void interrupted() {
        System.out.println("STOPPED TANK DRIVE");
        Robot.sDrive.stop();
    }
}
