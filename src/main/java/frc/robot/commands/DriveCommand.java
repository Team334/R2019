package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {

    double lastJoystickLeft;
    double lastJoystickRight;
    double leftSpeed;
    double rightSpeed;

    public DriveCommand() {
        requires(Robot.sDrive);
    }

    @Override
    protected void initialize() {
        System.out.println("TANK DRIVE INITIALIZED");
    }

    @Override
    protected void execute() {
        if ((Robot.m_oi.getLeftJoystick().getY() < 0 && lastJoystickLeft > 0) || (Robot.m_oi.getLeftJoystick().getY() > 0 && lastJoystickLeft < 0)){
            leftSpeed = 0;
        }else{
            leftSpeed = Robot.m_oi.getLeftJoystick().getY();
        }
        if ((Robot.m_oi.getRightJoystick().getY() < 0 && lastJoystickRight > 0) || (Robot.m_oi.getRightJoystick().getY() > 0 && lastJoystickRight < 0)){
            rightSpeed = 0;
        }
        else{
            rightSpeed = Robot.m_oi.getRightJoystick().getY();
        }

        Robot.sDrive.setLeft(leftSpeed);
        Robot.sDrive.setRight(rightSpeed);


        lastJoystickLeft = Robot.m_oi.getLeftJoystick().getY();
        lastJoystickRight = Robot.m_oi.getRightJoystick().getY();
    }

    @Override
    protected boolean isFinished() { return false; }

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
