package frc.robot.commands.Auton.Scenarios;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.Auton.CommandGroups.*;

public class RightRocket1Hatch extends CommandGroup {
    
    public RightRocket1Hatch() {
        addSequential(new RightStartHatchRocket());
    }
    
}
