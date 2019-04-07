package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Intake.IntakeWindowCommand;

public class Intake extends Subsystem {

    // Declare intake sensors and motors.
    private VictorSP windowMotor;
    private VictorSP leftBeltMotor;
    private VictorSP rightBeltMotor;
    private VictorSP propupMotor;

    private AnalogPotentiometer rIntakePotentiometer;
    private Encoder rIntakeEncoder;

    public static boolean heldBallState = false;
  
    public Intake() {

        windowMotor = new VictorSP(RobotMap.WINDOW_MOTOR_PORT);
        leftBeltMotor = new VictorSP(RobotMap.LEFT_BELT_MOTOR_PORT);
        rightBeltMotor = new VictorSP(RobotMap.RIGHT_BELT_MOTOR_PORT);
        propupMotor = new VictorSP(RobotMap.PROPUP_MOTOR_PORT);

        rIntakePotentiometer = new AnalogPotentiometer(RobotMap.INTAKE_POT_PORT);
        rIntakeEncoder = new Encoder(RobotMap.INTAKE_ENC_SOURCE_A, RobotMap.INTAKE_ENC_SOURCE_B);
    }

    public void setBeltMotors(double speed) { 
        leftBeltMotor.set(-speed); 
        rightBeltMotor.set(speed);
    }

    public void setWindowMotor(double speed) { windowMotor.set(speed); }

    public void setPropupMotor(double speed) { propupMotor.set(speed); }

    public double getPotentiometerValue() { return rIntakePotentiometer.get(); }

    public double getEncoderValue() { return rIntakeEncoder.getDistance(); }

    public Encoder getEncoder() { return rIntakeEncoder; }

    @Override
    public void initDefaultCommand() { setDefaultCommand(new IntakeWindowCommand()); }
    
}
