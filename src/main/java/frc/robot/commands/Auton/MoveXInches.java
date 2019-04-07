package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.pids.*;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.PIDController;

public class MoveXInches extends Command {

    private PIDController pidGyro;
    private PIDController pidEncoder;
    private double numOfTicks;

    private double setLeftSpeed;
    private double setRightSpeed;

    public MoveXInches(double inches) {
        requires(Robot.sDrive);
        numOfTicks = -inches * Constants.TICKS_PER_INCH;
        pidGyro = new PIDController(Constants.MOVE_X_FEET_GYRO_P, Constants.MOVE_X_FEET_GYRO_I, Constants.MOVE_X_FEET_GYRO_D, new HeadingPIDSource(), new StandardPIDOutput());
        pidEncoder = new PIDController(Constants.MOVE_X_FEET_ENC_P, Constants.MOVE_X_FEET_ENC_I, Constants.MOVE_X_FEET_ENC_D, new CANEncoderPIDSource(), new StandardPIDOutput());    
    }

    @Override
    protected void initialize() {
        Robot.sDrive.getLeftEncoder().setPosition(0);
        Robot.sDrive.getRightEncoder().setPosition(0);

        pidGyro.reset();
        pidGyro.setSetpoint(Robot.trueHeading);
        pidGyro.setAbsoluteTolerance(1);
        pidGyro.setOutputRange(-0.2, 0.2);
        pidGyro.enable();

        pidEncoder.reset();
        pidEncoder.setSetpoint(numOfTicks);
        pidEncoder.setAbsoluteTolerance(3);
        pidEncoder.setOutputRange(-0.4, 0.4);
        pidEncoder.enable();
    }

    @Override
    protected void execute() {
        setLeftSpeed = pidEncoder.get() - pidGyro.get();
        setRightSpeed = pidEncoder.get() + pidGyro.get();

        if (Drive.rGyro.isInitialized()) {
            Robot.sDrive.setLeft(setLeftSpeed);
            Robot.sDrive.setRight(setRightSpeed);
        }
    }

    @Override
    protected boolean isFinished() { 
        return pidEncoder.onTarget() || OI.autonOverride.get();
    }

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
