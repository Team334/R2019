package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.Elevator.JoystickElevator;

public class Elevator extends PIDSubsystem {

    private PWMVictorSPX pro1;
    private PWMVictorSPX pro2;
    private PWMVictorSPX pro3;
    private PWMVictorSPX pro4;

    public static Encoder rEncoder;

    public Elevator() {
        super(Constants.ELEVATOR_ENC_P, Constants.ELEVATOR_ENC_I, Constants.ELEVATOR_ENC_D);
        
        pro1 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_TL);
        pro2 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_TR);
        pro3 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_BL);
        pro4 = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_BR);

        rEncoder = new Encoder(RobotMap.ELEVATOR_ENC_A, RobotMap.ELEVATOR_ENC_B);

        this.disable();
        this.setAbsoluteTolerance(1000);
        this.setOutputRange(-0.4, 0.4);
    }

    public void setMotors(double speed) {
        pro1.set(speed - Constants.ELEVATOR_STATIC_OFFSET);
        pro2.set(speed - Constants.ELEVATOR_STATIC_OFFSET);
        pro3.set(speed - Constants.ELEVATOR_STATIC_OFFSET);
        pro4.set(speed - Constants.ELEVATOR_STATIC_OFFSET);
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
    protected void usePIDOutput(double output) { setMotors(-output); }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickElevator());
    }

}
