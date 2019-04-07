package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pids.*;
import frc.robot.subsystems.*;
import frc.robot.Constants;

public class Curve extends Command {

    private PIDController pidGyro;
    private double angle;
    private double output;
    private double leftSideSpeedPrev = 0;
    private double rightSideSpeedPrev = 0;

    private double setLeftSpeed;
    private double setRightSpeed;

    public Curve(double angle, double output) {
        requires(Robot.sDrive);
        pidGyro = new PIDController(Constants.CURVE_P, Constants.CURVE_I, Constants.CURVE_D, new HeadingPIDSource(), new StandardPIDOutput());
        this.angle = angle;
        this.output = output;
    }


    @Override
    protected void initialize() {
        Drive.rGyro.resetHeading();
        Robot.sDrive.getLeftEncoder().setPosition(0);
        Robot.sDrive.getRightEncoder().setPosition(0);

        pidGyro.reset();
        pidGyro.setSetpoint(angle);
        pidGyro.setAbsoluteTolerance(1);
        pidGyro.setOutputRange(-output, output);
        pidGyro.enable();
    }

    @Override
    protected void execute() {
        System.out.println(Drive.rGyro.getHeading());

        if ((leftSideSpeedPrev < 0 && (pidGyro.get()) > 0) || (leftSideSpeedPrev > 0 && (pidGyro.get()) < 0)) {
            setLeftSpeed = 0;
        } else {
            setLeftSpeed = pidGyro.get();
        }

        if ((rightSideSpeedPrev < 0 && (pidGyro.get()) > 0) || (rightSideSpeedPrev > 0 && (pidGyro.get()) < 0)) {
            setRightSpeed = 0;
        } else {
            setRightSpeed = pidGyro.get();
        }

        if (Drive.rGyro.isInitialized()) {
            Robot.sDrive.setLeft(setLeftSpeed + 0.3);
            Robot.sDrive.setRight(setRightSpeed - 0.3);
        }

        leftSideSpeedPrev = pidGyro.get();
        rightSideSpeedPrev = pidGyro.get();

    }

    @Override
    protected boolean isFinished() { return pidGyro.onTarget(); }

    @Override
    protected void end() {
        Robot.sDrive.stop();
        pidGyro.reset();
        pidGyro.disable();
    }


    @Override
    protected void interrupted() {
        Robot.sDrive.stop();
        pidGyro.reset();
        pidGyro.disable();
    }
    
}
