package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.Auton.Scenarios.*;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  
    public static Intake sIntake;
    public static Elevator sElevator;
    public static Drive sDrive;
    public static OI oi;

    public static CameraServer driverCamera;

    private SendableChooser<String> autonChooser;

    @Override
    public void robotInit() {
        sIntake = new Intake();
        sElevator = new Elevator();
        sDrive = new Drive();

        oi = new OI();

        driverCamera = CameraServer.getInstance();
        driverCamera.startAutomaticCapture();

        autonChooser = new SendableChooser<>();
        autonChooser.setDefaultOption("Left", "L");
        autonChooser.addOption("Right", "R");
        autonChooser.addOption("None", "N");
    }

    @Override
    public void robotPeriodic() { }

    @Override
    public void disabledInit() { }

    @Override
    public void disabledPeriodic() { }

    @Override
    public void autonomousInit() {
        sDrive.getLeftEncoder().setPosition(0);
        sDrive.getRightEncoder().setPosition(0);

        String startPosition = autonChooser.getSelected();

        switch(startPosition) {
            case "L":
                // Scheduler.getInstance().add(new LeftRocket1Hatch());
                break;
            case "R":
                // Scheduler.getInstance().add(new RightRocket1Hatch());
                break;
            case "N":
                break;
            default:
        }
    }

    @Override
    public void autonomousPeriodic() { Scheduler.getInstance().run(); }

    @Override
    public void teleopInit() { 
        Scheduler.getInstance().removeAll();
        Elevator.rEncoder.reset();
        sDrive.setDriveSpeed();
    }

    @Override
    public void teleopPeriodic() { 
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() { }
    
}
