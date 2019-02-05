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
    VictorSP windowMotor;
    VictorSP beltMotor;
    VictorSP propupMotor;
    AnalogPotentiometer rIntakePot;
    public PIDController intakePID;
  
    public Intake() {
        // Initialize intake sensors and motors.
        windowMotor = new VictorSP(RobotMap.WINDOW_MOTOR_PORT);
        beltMotor = new VictorSP(RobotMap.BELT_MOTOR_PORT);
        propupMotor = new VictorSP(RobotMap.PROPUP_MOTOR_PORT);
        rIntakePot = new AnalogPotentiometer(6);

        // Currently causes and error and is commented out temporarily.
        //intakePID = new PIDController(RobotMap.INTAKEPID_P, RobotMap.INTAKEPID_I, RobotMap.INTAKEPID_D, Robot.sIntake.getPotentiometer(), new StandardPIDOutput());
    }

    public void setBeltMotors(double speed) {
        // Sets both motors to spin belts at given speed.
        beltMotor.set(speed);
        //rightBeltMotor.set(-speed);
    }

    public void setWindowMotor(double speed) {
        // Sets window motor to open/close arm at certain speed.
        windowMotor.set(speed);
    }

    public void setPropupMotor(double speed) {
        // Sets the speed of the propup to the given speed.
        propupMotor.set(speed);
    }

    public double getPotentiometerValue() { 
        // Returns the reading from the potentiometer.
        return rIntakePot.get(); 
    }

    public AnalogPotentiometer getPotentiometer() {
        // Get the potentiometer object.
        return rIntakePot;
    }

    public VictorSP getWindowMotor() {
        // Get the window motor object.
        return windowMotor;
    }

    @Override
    public void initDefaultCommand() { 
        // IntakeWindowCommand is always run to allow opening and closing of arm at all times.
        setDefaultCommand(new IntakeWindowCommand()); 
    }
}
