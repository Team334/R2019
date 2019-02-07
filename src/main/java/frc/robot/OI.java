package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    private Joystick leftJoystick;
    private Joystick rightJoystick;

    public OI() {
        leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
        rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
    }

    public Joystick getLeftJoystick() { return leftJoystick; }
    
    public Joystick getRightJoystick() { return rightJoystick; }

}
