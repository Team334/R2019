package frc.robot.commands.Auton.Scenarios;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.Auton.CommandGroups.*;

public class LeftRocket2Hatch extends CommandGroup {
    
    public LeftRocket2Hatch() {
        addSequential(new LeftStartHatchRocket());
        addSequential(new LeftHatchRocketPickup());
        addSequential(new LeftHatchRocketReturn());
    }
    
}
