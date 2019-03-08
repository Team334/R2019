package frc.robot.commands.Auton.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.Constants;
import frc.robot.commands.Auton.Curve;
import frc.robot.commands.Elevator.SetElevatorHeight;
import frc.robot.commands.Intake.*;

public class RightStartHatchRocket extends CommandGroup {

    public RightStartHatchRocket() {
        // addSequential(new LatchHatchCommand());
        addParallel(new Curve(35, 0.8));
        addParallel(new SetElevatorHeight(Constants.ELEVATOR_ENC_LOW_HATCH));
        // addSequential(new ReleaseHatchCommand());
    }

}
