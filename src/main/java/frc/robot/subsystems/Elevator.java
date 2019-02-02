package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

    private PWMVictorSPX pro1;
    private PWMVictorSPX pro2;
    private PWMVictorSPX pro3;
    private PWMVictorSPX pro4;

    public static Encoder rEncoder;

    public Elevator() {
        super(1, 2, 3);
        // initialize 775 pros.
        pro1 = new PWMVictorSPX(1);
        pro2 = new PWMVictorSPX(2);
        pro3 = new PWMVictorSPX(3);
        pro4 = new PWMVictorSPX(4);

        rEncoder = new Encoder(1, 2);

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
    protected double returnPIDInput() {
        return rEncoder.get();
    }

    @Override
    protected void usePIDOutput(double output) {
        setMotors(output * 0.1);
    }

    @Override
    public void initDefaultCommand() {

    }
}
