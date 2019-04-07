package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class HoldBallCommand extends Command {

    public HoldBallCommand() { requires(Robot.sIntake); }

    @Override
    protected void initialize() {    
        Intake.heldBallState = true;
    }

    @Override
    protected void execute() {
        Robot.sIntake.setWindowMotor(0.5);
     }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() {
        Robot.sIntake.setWindowMotor(0);
        Intake.heldBallState = false;
    }

    @Override
    protected void interrupted() {
        Robot.sIntake.setWindowMotor(0);
        Intake.heldBallState = false;
    }
    
}
