package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pids.*;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.PIDController;
import frc.robot.Constants;

public class TurnXAngle extends Command {

    private PIDController pidController;

    public TurnXAngle(double angle) {
        requires(Robot.sDrive);
        Robot.trueHeading += angle;
        pidController = new PIDController(Constants.TURN_X_ANGLE_P, Constants.TURN_X_ANGLE_I, Constants.TURN_X_ANGLE_D, new HeadingPIDSource(), new StandardPIDOutput());
    }

    @Override
    protected void initialize() {
        System.out.println("Initialized starting to adjust!");
        pidController.reset();
        pidController.setSetpoint(Robot.trueHeading);
        pidController.setAbsoluteTolerance(1);
        pidController.setOutputRange(-0.75, 0.75);
        pidController.enable();
    }

    @Override
    protected void execute() {
        if (Drive.rGyro.isInitialized()) {
            Robot.sDrive.setLeft(-pidController.get());
            Robot.sDrive.setRight(pidController.get());
        }
    }

    @Override
    protected boolean isFinished() { return pidController.onTarget(); }

    @Override
    protected void end() {
        Robot.sDrive.stop();
        Drive.rGyro.resetHeading();
        pidController.disable();
    }

    @Override
    protected void interrupted() {
        Robot.sDrive.stop();
        pidController.disable();
    }
    
}
