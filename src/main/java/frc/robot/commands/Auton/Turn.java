package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.pids.*;
import frc.robot.subsystems.*;
import frc.robot.Constants;

public class Turn extends Command {

    private PIDController pidGyro;
    private double angle;
    private int ticks;
    private double leftSideSpeedPrev = 0;
    private double rightSideSpeedPrev = 0;

    private double setLeftSpeed;
    private double setRightSpeed;
    private double speed;

    public Turn(double angle, int ticks, double speed) {
        requires(Robot.sDrive);
        pidGyro = new PIDController(Constants.TURN_P, Constants.TURN_I, Constants.TURN_D, new HeadingPIDSource(), new StandardPIDOutput());
        this.angle = angle;
        this.ticks = ticks;
        this.speed = speed;
    }


    @Override
    protected void initialize() {
        Drive.rEncoder1.reset();
        Drive.rEncoder2.reset();
        Drive.rGyro.resetHeading();

        pidGyro.reset();
        pidGyro.setSetpoint(angle);
        pidGyro.setAbsoluteTolerance(1);
        pidGyro.setOutputRange(-0.5, 0.5);
        pidGyro.enable();
        System.out.println("Working!");
    }

    @Override
    protected void execute() {
        if ((leftSideSpeedPrev < 0 && (-speed + pidGyro.get()) > 0) || (leftSideSpeedPrev > 0 && (-speed + pidGyro.get()) < 0)){
            setLeftSpeed = 0;
        } else {
        setLeftSpeed = -speed + pidGyro.get();
        }

        if ((rightSideSpeedPrev < 0 && (speed + pidGyro.get()) > 0) || (rightSideSpeedPrev > 0 && (speed + pidGyro.get()) < 0)){
            setRightSpeed = 0;
        } else {
            setRightSpeed = speed + pidGyro.get();
        }

        if (Drive.rGyro.isInitialized()){
            Robot.sDrive.setLeft(setLeftSpeed);
            Robot.sDrive.setRight(setRightSpeed);
        }

        leftSideSpeedPrev = -speed + pidGyro.get();
        rightSideSpeedPrev = speed + pidGyro.get();

    }

    @Override
    protected boolean isFinished() { return Drive.rEncoder1.get() > ticks; }

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