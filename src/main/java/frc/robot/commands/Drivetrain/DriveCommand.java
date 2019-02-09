package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {

    private double lastJoystickLeft;
    private double lastJoystickRight;
    private double leftSpeed;
    private double rightSpeed;

    public DriveCommand() { requires(Robot.sDrive); }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        if ((Robot.oi.getLeftJoystick().getY() < 0 && lastJoystickLeft > 0) || (Robot.oi.getLeftJoystick().getY() > 0 && lastJoystickLeft < 0)) {
            leftSpeed = 0;
        } else {
            leftSpeed = Robot.oi.getLeftJoystick().getY();
        }
        
        if ((Robot.oi.getRightJoystick().getY() < 0 && lastJoystickRight > 0) || (Robot.oi.getRightJoystick().getY() > 0 && lastJoystickRight < 0)) {
            rightSpeed = 0;
        } else {
            rightSpeed = Robot.oi.getRightJoystick().getY();
        }

        Robot.sDrive.setLeft(leftSpeed);
        Robot.sDrive.setRight(rightSpeed);

        lastJoystickLeft = Robot.oi.getLeftJoystick().getY();
        lastJoystickRight = Robot.oi.getRightJoystick().getY();
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { 
        Robot.sDrive.stop(); 
        System.out.println("STOPPED TANK DRIVE");
    }

    @Override
    protected void interrupted() { 
        Robot.sDrive.stop();
        System.out.println("INTERRUPTED TANK DRIVE");
    }

}

