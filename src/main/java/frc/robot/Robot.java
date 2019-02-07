package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
    
    public static OI oi;
    public static Drive sDrive;

    @Override
    public void robotInit() {
        sDrive = new Drive();
        oi = new OI();
    }

    @Override
    public void robotPeriodic() { }

    @Override
    public void disabledInit() { }

    @Override
    public void disabledPeriodic() { }

    @Override
    public void autonomousInit() { }

    @Override
    public void autonomousPeriodic() { }

    @Override
    public void teleopInit() { Scheduler.getInstance().removeAll(); }

    @Override
    public void teleopPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void testPeriodic() { }
}
