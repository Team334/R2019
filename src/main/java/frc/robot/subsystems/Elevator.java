package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.Elevator.JoystickElevator;

public class Elevator extends PIDSubsystem {

    private PWMVictorSPX pro1;
    private PWMVictorSPX pro2;
    private PWMVictorSPX pro3;
    private PWMVictorSPX pro4;

    private DigitalInput rTopLimit;
    private DigitalInput rBottomLimit;

    public static Encoder rEncoder;

    public Elevator() {
        super(Constants.ELEVATOR_ENC_P, Constants.ELEVATOR_ENC_I, Constants.ELEVATOR_ENC_D);
        // This will initialize the 775 pros.
        pro1 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_TL);
        pro2 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_TR);
        pro3 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_BL);
        pro4 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_BR);

        rEncoder = new Encoder(RobotMap.ELEVATOR_ENC_A, RobotMap.ELEVATOR_ENC_B);

        rTopLimit = new DigitalInput(RobotMap.ELEVATOR_LIMIT_TOP);
        rBottomLimit = new DigitalInput(RobotMap.ELEVATOR_LIMIT_BOTTOM);

        this.disable();
        this.setAbsoluteTolerance(1);
        this.setOutputRange(-1, 1);
    }

    public void setMotors(double speed) {
        pro1.set(speed);
        pro2.set(speed);
        pro3.set(speed);
        pro4.set(speed);
    }

    public void stop() {
        pro1.set(0);
        pro2.set(0);
        pro3.set(0);
        pro4.set(0);
    }

    @Override
    protected double returnPIDInput() { return rEncoder.get(); }

    @Override
    protected void usePIDOutput(double output) { setMotors(output); }

    public boolean isTooHigh() { return rTopLimit.get(); }
 
    public boolean isTooLow() { return rBottomLimit.get(); }

    @Override
    public void initDefaultCommand() {
        JoystickElevator JoystickElevator = new JoystickElevator();
    }

}