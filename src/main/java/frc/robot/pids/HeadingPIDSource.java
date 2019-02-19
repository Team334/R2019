package frc.robot.pids;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.robot.subsystems.Drive;

public class HeadingPIDSource implements PIDSource {

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) { }

    @Override
    public PIDSourceType getPIDSourceType() { return PIDSourceType.kDisplacement; }

    @Override
    public double pidGet() { return Drive.rGyro.getHeading(); }

}
