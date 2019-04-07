package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.*;

import frc.robot.commands.Auton.CommandGroups.*;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  
    public static Intake sIntake;
    public static Elevator sElevator;
    public static Drive sDrive;
    public static OI oi;

    public static CameraServer driverCamera;

    private SendableChooser<String> autonChooser;
    private DriverStation fms = DriverStation.getInstance();
    private DriverStation.Alliance alliance = fms.getAlliance();

    public static int trueHeading;

    @Override
    public void robotInit() {
        if (alliance.equals(DriverStation.Alliance.Blue)) {

        } else if (alliance.equals(DriverStation.Alliance.Red)) {
            
        } else {
            
        }

        sIntake = new Intake();
        sElevator = new Elevator();
        sDrive = new Drive();

        oi = new OI();

        driverCamera = CameraServer.getInstance();
        driverCamera.startAutomaticCapture();

        autonChooser = new SendableChooser<>();
        autonChooser.setDefaultOption("Left", "L");
        autonChooser.addOption("Right", "R");
        autonChooser.addOption("Center", "C");
        autonChooser.addOption("None", "N");
        SmartDashboard.putData("Auton Selector", autonChooser);
    }

    @Override
    public void robotPeriodic() { 
        SmartDashboard.putBoolean("Ball Lock Command State", Intake.heldBallState);
    }

    @Override
    public void disabledInit() { }

    @Override
    public void disabledPeriodic() { }

    @Override
    public void autonomousInit() {
        trueHeading = 0;
        Scheduler.getInstance().removeAll();
        Elevator.rEncoder.reset();
        sDrive.getLeftEncoder().setPosition(0);
        sDrive.getRightEncoder().setPosition(0);
        sIntake.getEncoder().reset();
        Drive.rGyro.resetHeading();

        sDrive.setAutonSpeed();

        String startPosition = autonChooser.getSelected();

        switch(startPosition) {
            case "L":
                break;
            case "R":
                break;
            case "C":
                break;
            case "N":
                break;
            default:
        }

    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() { 
        Scheduler.getInstance().removeAll();
        sDrive.setDriveSpeed();
    }

    @Override
    public void teleopPeriodic() { 
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() { }
    
}
