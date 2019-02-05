package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
    // Declare oi and subsystems.
    public static OI oi;
    public static Intake sIntake;

    @Override
    public void robotInit() {
    // Initialize oi and subsystems.
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
    public void autonomousPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() { 
        Scheduler.getInstance().run(); 
        // Shuffleboard display.
        SmartDashboard.putNumber("Intake Potentiometer", sIntake.getPotentiometerValue());
        SmartDashboard.putNumber("Intake PID Error:", sIntake.intakePID.getError());
        SmartDashboard.putNumber("Intake PID Output", sIntake.intakePID.get());
        SmartDashboard.putNumber("Window Motor Speed", sIntake.windowMotor.get());
    }

    @Override
    public void testPeriodic() {

    }
}
