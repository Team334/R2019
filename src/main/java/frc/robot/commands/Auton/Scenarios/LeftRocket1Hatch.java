package frc.robot.commands.Auton.Scenarios;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.Auton.CommandGroups.*;

public class LeftRocket1Hatch extends CommandGroup {
    
    public LeftRocket1Hatch() {
        addSequential(new RightStartHatchRocket());
    }
    
}
