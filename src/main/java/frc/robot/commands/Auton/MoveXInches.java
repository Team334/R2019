package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.pids.*;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.PIDController;

public class MoveXInches extends Command {

    private PIDController pidGyro;
    private PIDController pidEncoder;
    private double numOfTicks;

    private double leftSideSpeedPrev = 0;
    private double rightSideSpeedPrev = 0;

    private double setLeftSpeed;
    private double setRightSpeed;

    public MoveXInches(double inches) {
        requires(Robot.sDrive);
        numOfTicks = inches * Constants.TICKS_PER_INCH;
        pidGyro = new PIDController(Constants.MOVE_X_FEET_GYRO_P, Constants.MOVE_X_FEET_GYRO_I, Constants.MOVE_X_FEET_GYRO_D, new HeadingPIDSource(), new StandardPIDOutput());
        pidEncoder = new PIDController(Constants.MOVE_X_FEET_ENC_P, Constants.MOVE_X_FEET_ENC_I, Constants.MOVE_X_FEET_ENC_D, new CANEncoderPIDSource(), new StandardPIDOutput());    
    }

    @Override
    protected void initialize() {
        Drive.rGyro.resetHeading();
        pidGyro.reset();
        pidGyro.setSetpoint(0);
        pidGyro.setAbsoluteTolerance(1);
        pidGyro.setOutputRange(-0.5, 0.5);
        pidGyro.enable();

        pidEncoder.reset();
        pidEncoder.setSetpoint(Robot.sDrive.getLeftEncoder().getPosition() + numOfTicks);
        pidEncoder.setAbsoluteTolerance(10);
        pidEncoder.setOutputRange(-0.5,0.5);
        pidEncoder.enable();
    }

    @Override
    protected void execute() {
        if ((leftSideSpeedPrev < 0 && (-pidEncoder.get() + pidGyro.get()) > 0) || (leftSideSpeedPrev > 0 && (-pidEncoder.get() + pidGyro.get()) < 0)) {
            setLeftSpeed = 0;
        } else {
            setLeftSpeed = -pidEncoder.get() + pidGyro.get();
        }
    
        if ((rightSideSpeedPrev < 0 && (pidEncoder.get() + pidGyro.get()) > 0) || (rightSideSpeedPrev > 0 && (pidEncoder.get() + pidGyro.get()) < 0)) {
            setRightSpeed = 0;
        } else {
            setRightSpeed = pidEncoder.get() + pidGyro.get();
        }
        
        leftSideSpeedPrev = -pidEncoder.get() + pidGyro.get();
        rightSideSpeedPrev = pidEncoder.get() + pidGyro.get();

        if (Drive.rGyro.isInitialized()) {
            Robot.sDrive.setLeft(setLeftSpeed);
            Robot.sDrive.setRight(setRightSpeed);
        }
    }

    @Override
    protected boolean isFinished() { return pidEncoder.onTarget() && pidGyro.onTarget(); }

    @Override
    protected void end() {
        Robot.sDrive.stop();
        pidEncoder.disable();
        pidGyro.disable();
    }

    @Override
    protected void interrupted() {
        Robot.sDrive.stop();
        pidEncoder.disable();
        pidGyro.disable();
    }
    
}
