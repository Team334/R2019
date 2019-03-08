package frc.robot.commands.Auton.Scenarios;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.Auton.CommandGroups.*;

public class RightRocket2Hatch extends CommandGroup {
    
    public RightRocket2Hatch() {
        addSequential(new RightStartHatchRocket());
        addSequential(new RightHatchRocketPickup());
        addSequential(new RightHatchRocketReturn());
    }
    
}
