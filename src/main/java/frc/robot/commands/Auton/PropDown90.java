package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class PropDown90 extends Command {

    public PropDown90() {
        requires(Robot.sIntake);
    }
    
    @Override
    protected void initialize() {

    }
    
    @Override
    protected void execute() {
        Robot.sIntake.setPropupMotor(0.8);
    }
    
    @Override
    protected boolean isFinished() {
        return Robot.sIntake.getEncoderValue() > Constants.INTAKE_PROP_90;
    }
    
    @Override
    protected void end() {
        Robot.sIntake.setPropupMotor(0);
    }
    
    @Override
    protected void interrupted() {
        Robot.sIntake.setPropupMotor(0);
    }
}
