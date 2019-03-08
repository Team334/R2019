package frc.robot.commands.Auton.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.Auton.*;

public class LeftHatchRocketPickup extends CommandGroup {
    
    public LeftHatchRocketPickup() {
        addSequential(new TurnXAngle(215));
        addSequential(new MoveXInches(178));
    }
    
}
