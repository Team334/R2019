package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class Drive extends Subsystem {

    private CANSparkMax leftTop;
    private CANSparkMax leftMid;
    private CANSparkMax leftBot;
    private CANSparkMax rightTop;
    private CANSparkMax rightMid;
    private CANSparkMax rightBot;

    private SpeedControllerGroup left;
    private SpeedControllerGroup right;
    
    public Drive() {
        leftTop = new CANSparkMax(RobotMap.LEFT_TOP_DRIVE_MOTOR, MotorType.kBrushless);
        leftMid = new CANSparkMax(RobotMap.LEFT_MID_DRIVE_MOTOR, MotorType.kBrushless);
        leftBot = new CANSparkMax(RobotMap.LEFT_BOT_DRIVE_MOTOR, MotorType.kBrushless);

        rightTop = new CANSparkMax(RobotMap.RIGHT_TOP_DRIVE_MOTOR, MotorType.kBrushless);
        rightMid = new CANSparkMax(RobotMap.RIGHT_MID_DRIVE_MOTOR, MotorType.kBrushless);
        leftBot = new CANSparkMax(RobotMap.RIGHT_BOT_DRIVE_MOTOR, MotorType.kBrushless);

        left = new SpeedControllerGroup(leftTop, leftMid,leftBot);
        right = new SpeedControllerGroup(rightTop,rightMid,rightBot);        
    }

    @Override
    public void initDefaultCommand() { setDefaultCommand(new DriveCommand());}

    public void setLeft(double speed) {
        // Sets the speed to the speed parameter.
        left.set(speed);
    }

    public void setRight(double speed) {
        // Sets the speed to the speed parameter.
        right.set(speed);
    }

    public void stop() {
        left.set(0);
        right.set(0);
    }

}
