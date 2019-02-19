package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pids.*;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.PIDController;
import frc.robot.Constants;

public class TurnXAngle extends Command {

    private double angle;
    private PIDController pidController;
    private double lastPIDvalue = 0;
    private double value;

    public TurnXAngle(double angle) {
        requires(Robot.sDrive);
        this.angle = angle;
        pidController = new PIDController(Constants.TURN_X_ANGLE_P, Constants.TURN_X_ANGLE_I, Constants.TURN_X_ANGLE_D, new HeadingPIDSource(), new StandardPIDOutput());
    }

    @Override
    protected void initialize() {
        Drive.rGyro.resetHeading();
        System.out.println("Initialized starting to adjust!");
        System.out.println(Drive.rGyro.isInitialized());
        pidController.reset();
        pidController.setSetpoint(angle);
        pidController.setAbsoluteTolerance(1);
        pidController.setOutputRange(-0.75, 0.75);
        pidController.enable();
    }

    @Override
    protected void execute() {
        System.out.println(pidController.get());
        if ((lastPIDvalue > 0 && pidController.get() < 0) || (lastPIDvalue < 0 && pidController.get() > 0)) {
            value = 0;
        } else {
            value = pidController.get();
        }

        if (Drive.rGyro.isInitialized()) {
            Robot.sDrive.setLeft(value);
            Robot.sDrive.setRight(value);
        }
        
        lastPIDvalue = pidController.get();
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
