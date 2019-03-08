package frc.robot.commands.Auton.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.Constants;
import frc.robot.commands.Auton.*;
import frc.robot.commands.Elevator.SetElevatorHeight;
import frc.robot.commands.Intake.ReleaseHatchCommand;

public class RightHatchRocketReturn extends CommandGroup {
    
    public RightHatchRocketReturn() {
        addSequential(new MoveXInches(-12));
        addSequential(new TurnXAngle(-180));
        addSequential(new MoveXInches(166));
        addParallel(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW_HATCH));
        addSequential(new ReleaseHatchCommand());
    }
    
}
