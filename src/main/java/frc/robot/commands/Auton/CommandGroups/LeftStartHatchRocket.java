package frc.robot.commands.Auton.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.Constants;
import frc.robot.commands.Auton.*;
import frc.robot.commands.Elevator.SetElevatorHeight;
import frc.robot.commands.Intake.ReleaseHatchCommand;

public class LeftStartHatchRocket extends CommandGroup {

    public LeftStartHatchRocket() {
        addParallel(new Curve(-35, 0.8));
        addParallel(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW_HATCH));
        addSequential(new ReleaseHatchCommand());
    }

}
