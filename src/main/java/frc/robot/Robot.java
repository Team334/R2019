package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.Elevator.JoystickElevator;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  
    public static Intake sIntake;
    public static Elevator sElevator;
    public static Drive sDrive;
    public static OI oi;

    public static CameraServer driverCamera;

    @Override
    public void robotInit() {
        sIntake = new Intake();
        sElevator = new Elevator();
        sDrive = new Drive();

        oi = new OI();

        driverCamera = CameraServer.getInstance();
        driverCamera.startAutomaticCapture();
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
    public void teleopInit() { 
        Elevator.rEncoder.reset();
    }

    @Override
    public void teleopPeriodic() { 
        Scheduler.getInstance().run();
        System.out.println(Elevator.rEncoder.get());
    }

    @Override
    public void testPeriodic() { }
    
}
