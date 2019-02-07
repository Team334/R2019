package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LatchHatchCommand extends Command {
    
    public LatchHatchCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {
        // Sets up the pid so it opens the arms and holds the hatch with a bit of pressure.
        Robot.sIntake.intakePID.reset();
        Robot.sIntake.intakePID.setSetpoint(RobotMap.LATCH_HATCH_SETPOINT);
        Robot.sIntake.intakePID.setAbsoluteTolerance(RobotMap.INTAKE_PID_TOLERANCE);
        Robot.sIntake.intakePID.setOutputRange(RobotMap.INTAKE_PID_RANGE[0], RobotMap.INTAKE_PID_RANGE[1]);

        Robot.sIntake.intakePID.enable();
    }

    @Override
    protected void execute() {
        // Sets motor speed to the PID output.
        Robot.sIntake.setWindowMotor(Robot.sIntake.intakePID.get());
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() {
        // Turns the pid off and stops the motor.
        Robot.sIntake.intakePID.disable();
        Robot.sIntake.setWindowMotor(0);
    }

    @Override
    protected void interrupted() {
        Robot.sIntake.intakePID.disable();
        Robot.sIntake.setWindowMotor(0);
    }
    
}
