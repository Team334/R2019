package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
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
    public void teleopInit() { }

    @Override
    public void teleopPeriodic() { }

    @Override
    public void testPeriodic() { }
}
