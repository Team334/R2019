package frc.robot.commands.Auton.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.commands.Auton.*;
import frc.robot.commands.Elevator.SetElevatorHeight;

public class CenterHatch extends CommandGroup {
    
    public CenterHatch() {
        addSequential(new MoveXInches(31));
        addSequential(new PropDown90());
        addParallel(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW_HATCH));
    }

    public boolean isFinished() {
        return OI.autonOverride.get();
    }
    
}
