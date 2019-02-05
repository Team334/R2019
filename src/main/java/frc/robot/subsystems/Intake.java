package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.StandardPIDOutput;
import frc.robot.commands.IntakeWindowCommand;

public class Intake extends Subsystem {
    // Declare intake sensors and motors.
    public VictorSP windowMotor;
    VictorSP leftBeltMotor;
    VictorSP rightBeltMotor;
    AnalogPotentiometer rIntakePot;
    public PIDController intakePID;
  
    public Intake() {
        // Initialize intake sensors and motors.
        windowMotor = new VictorSP(RobotMap.WINDOW_MOTOR_PORT);
        leftBeltMotor = new VictorSP(RobotMap.LEFTBELT_MOTOR_PORT);
        rightBeltMotor = new VictorSP(RobotMap.RIGHTBELT_MOTOR_PORT);
        rIntakePot = new AnalogPotentiometer(6);

        intakePID = new PIDController(RobotMap.INTAKEPID_P, RobotMap.INTAKEPID_I, RobotMap.INTAKEPID_D, Robot.sIntake.getPotentiometer(), new StandardPIDOutput());
    }

    public void setBeltMotors(double speed) {
        // Sets both motors to spin belts at given speed.
        leftBeltMotor.set(speed);
        rightBeltMotor.set(-speed);
    }

    public void setWindowMotor(double speed) {
        // Sets window motor to open/close arm at certain speed.
        windowMotor.set(speed);
    }

    public double getPotentiometerValue() {
        return rIntakePot.get();
    }

    public AnalogPotentiometer getPotentiometer() {
        return rIntakePot;
    }

    @Override
    public void initDefaultCommand() { 
        // IntakeWindowCommand is always run to allow opening and closing of arm at all times.
        setDefaultCommand(new IntakeWindowCommand()); 
    }
}
