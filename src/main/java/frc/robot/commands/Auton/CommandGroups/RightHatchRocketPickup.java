package frc.robot.commands.Auton.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.Auton.*;

public class RightHatchRocketPickup extends CommandGroup {
    
    public RightHatchRocketPickup() {
        addSequential(new MoveXInches(-12));
        addSequential(new TurnXAngle(-215));
        addSequential(new MoveXInches(166));
    }
    
}
