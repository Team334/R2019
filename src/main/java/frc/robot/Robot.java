package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

    public static Intake sIntake;
    public static Elevator sElevator;
    public static Drive sDrive;
    public static OI oi;

    @Override
    public void robotInit() {
        sIntake = new Intake();
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
    public void autonomousPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void teleopInit() { }

    @Override
    public void teleopPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void testPeriodic() { }
    
}
