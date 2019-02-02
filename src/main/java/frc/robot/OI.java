package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public static  Joystick leftJoystick;
    public static Joystick rightJoystick;
    public OI(){
        leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
    }
}
