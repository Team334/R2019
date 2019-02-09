package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.StandardPIDOutput;
import frc.robot.commands.Intake.IntakeWindowCommand;

public class Intake extends Subsystem {

    // Declare intake sensors and motors.
    private VictorSP windowMotor;
    private VictorSP beltMotor;
    private VictorSP propupMotor;
    private AnalogPotentiometer rIntakePot;
    public PIDController intakePID;
  
    public Intake() {
        // Initialize intake sensors, motors, and PID.
        windowMotor = new VictorSP(RobotMap.WINDOW_MOTOR_PORT);
        beltMotor = new VictorSP(RobotMap.BELT_MOTOR_PORT);
        propupMotor = new VictorSP(RobotMap.PROPUP_MOTOR_PORT);
        rIntakePot = new AnalogPotentiometer(6);
        intakePID = new PIDController(Constants.INTAKE_PID_P, Constants.INTAKE_PID_I, Constants.INTAKE_PID_D, Robot.sIntake.getPotentiometer(), new StandardPIDOutput());
    }

    public void setBeltMotors(double speed) { beltMotor.set(speed); }

    public void setWindowMotor(double speed) { windowMotor.set(speed); }

    public void setPropupMotor(double speed) { propupMotor.set(speed); }

    public double getPotentiometerValue() { return rIntakePot.get(); }

    public AnalogPotentiometer getPotentiometer() { return rIntakePot; }

    public VictorSP getWindowMotor() { return windowMotor; }

    @Override
    public void initDefaultCommand() { setDefaultCommand(new IntakeWindowCommand()); }
    
}
