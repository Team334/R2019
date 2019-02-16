package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Intake.IntakeWindowCommand;

public class Intake extends PIDSubsystem {

    // Declare intake sensors and motors.
    private VictorSP windowMotor;
    private VictorSP leftBeltMotor;
    private VictorSP rightBeltMotor;
    private VictorSP propupMotor;
    private AnalogPotentiometer rIntakePot;
    private Encoder rIntakeEnc;
    public double intakePIDOutput;
  
    public Intake() {
        super("Intake", Constants.INTAKE_PID_P, Constants.INTAKE_PID_I, Constants.INTAKE_PID_D);

        // Initialize intake sensors, motors, and PID.
        windowMotor = new VictorSP(RobotMap.WINDOW_MOTOR_PORT);
        leftBeltMotor = new VictorSP(RobotMap.LEFT_BELT_MOTOR_PORT);
        rightBeltMotor = new VictorSP(RobotMap.RIGHT_BELT_MOTOR_PORT);
        propupMotor = new VictorSP(RobotMap.PROPUP_MOTOR_PORT);
        rIntakePot = new AnalogPotentiometer(6);
        rIntakeEnc = new Encoder(RobotMap.INTAKE_ENC_SOURCE_A, RobotMap.INTAKE_ENC_SOURCE_B);
        intakePIDOutput = 0;
    }

    public void setBeltMotors(double speed) { 
        leftBeltMotor.set(speed); 
        rightBeltMotor.set(-speed);
    }

    public void setWindowMotor(double speed) { windowMotor.set(speed); }

    public void setPropupMotor(double speed) { propupMotor.set(speed); }

    public double getPotentiometerValue() { return rIntakePot.get(); }

    public AnalogPotentiometer getPotentiometer() { return rIntakePot; }

    public double getEncoderValue() { return rIntakeEnc.getDistance(); }

    public VictorSP getWindowMotor() { return windowMotor; }

    @Override
    protected double returnPIDInput() { return rIntakePot.get(); }
  
    @Override
    protected void usePIDOutput(double output) { intakePIDOutput = output; }

    @Override
    public void initDefaultCommand() { setDefaultCommand(new IntakeWindowCommand()); }
    
}
