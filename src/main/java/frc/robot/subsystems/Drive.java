package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;

import com.revrobotics.CANSparkMax;

public class Drive extends Subsystem {
    CANSparkMax leftTop;
    CANSparkMax leftMid;
    CANSparkMax leftBot;
    CANSparkMax rightTop;
    CANSparkMax rightMid;
    CANSparkMax rightBot;

    SpeedControllerGroup left;
    SpeedControllerGroup right;
    public Drive(){

        leftTop = new CANSparkMax(0, MotorType.kBrushless);
        leftMid = new CANSparkMax(1, MotorType.kBrushless);
        leftBot = new CANSparkMax(2, MotorType.kBrushless);
        rightTop = new CANSparkMax(3, MotorType.kBrushless);
        rightMid = new CANSparkMax(4, MotorType.kBrushless);
        leftBot = new CANSparkMax(5, MotorType.kBrushless);

        left = new SpeedControllerGroup(leftTop, leftMid,leftBot);
        right = new SpeedControllerGroup(rightTop,rightMid,rightBot);        
    }
    @Override
    public void initDefaultCommand() {
        new DriveCommand();
    }
    public void setLeft(double speed){
        left.set(speed);
    }
    public void setRight(double speed){
        right.set(speed);
    }
    public void stop(){
        left.set(0);
        right.set(0);
    }
}
