package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class IntakeWindowCommand extends Command {
    public IntakeWindowCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {
        
    }

    @Override
    protected void execute() {
        // Speed of the window motor is set to the x-axis of the operator joystick.
        Robot.sIntake.setWindowMotor(Robot.oi.getOperatorJoystick().getX() * RobotMap.WINDOWMOTOR_SPEED_MULT);

        // Alternate way of controlling propup with y-axis of operator joystick.
        Robot.sIntake.setPropupMotor(Robot.oi.getOperatorJoystick().getY() * 1);
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { 

    }

    @Override
    protected void interrupted() { 

    }
}
