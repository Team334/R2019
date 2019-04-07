package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveCommand extends Command {

    private double lastJoystickLeft = 0;
    private double lastJoystickRight = 0;
    private double leftSpeed;
    private double rightSpeed;

    private double multiplier;
    

    public DriveCommand() { requires(Robot.sDrive); }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {
        if (Robot.oi.getOperatorJoystick().getThrottle() <= -0.8) {
            multiplier = Constants.DRIVE_MULTIPLIER;
        } else {
            multiplier = 1;
        }

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

        Robot.sDrive.setLeft(leftSpeed / multiplier);
        Robot.sDrive.setRight(rightSpeed / multiplier);

        lastJoystickLeft = Robot.oi.getLeftJoystick().getY();
        lastJoystickRight = Robot.oi.getRightJoystick().getY();
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { 
        Robot.sDrive.stop(); 
    }

    @Override
    protected void interrupted() { 
        Robot.sDrive.stop();
    }

}

