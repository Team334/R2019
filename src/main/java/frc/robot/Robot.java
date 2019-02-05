package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
    // Declare oi and subsystems.
    public static Intake sIntake;
    public static OI oi;

    @Override
    public void robotInit() {
    // Initialize oi and subsystems.
        sIntake = new Intake();
        oi = new OI();
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
        //SmartDashboard.putNumber("Intake PID Error:", sIntake.intakePID.getError());
        //SmartDashboard.putNumber("Intake PID Output", sIntake.intakePID.get());
        SmartDashboard.putNumber("Window Motor Speed", sIntake.getWindowMotor().get());
    }

    @Override
    public void testPeriodic() {

    }
}
