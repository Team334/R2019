package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Intake;

public class Robot extends TimedRobot {
    //declare oi and subsystems
    public static OI oi;
    public static Intake sIntake;

    @Override
    public void robotInit() {
    //initialize oi and subsystems
        oi = new OI();
        sIntake = new Intake();
    }

    @Override
    public void robotPeriodic() {
    
    }

    @Override
    public void disabledInit() {
    
    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {
        
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
    
    }

    @Override
    public void testPeriodic() {

    }
}
