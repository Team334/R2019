package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  
    public static Elevator sElevator;
    public static OI oi;
    public static Drive sDrive;

    @Override
    public void robotInit() {
        sElevator = new Elevator();
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
