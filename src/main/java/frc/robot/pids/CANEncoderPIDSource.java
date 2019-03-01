package frc.robot.pids;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.robot.Robot;

public class CANEncoderPIDSource implements PIDSource {

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) { }

    @Override
    public PIDSourceType getPIDSourceType() { return PIDSourceType.kDisplacement; }

    @Override
    public double pidGet() { return Robot.sDrive.getLeftEncoder().getPosition(); }

}
