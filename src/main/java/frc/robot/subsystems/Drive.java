package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Drivetrain.DriveCommand;

public class Drive extends Subsystem {

    private CANSparkMax leftA;
    private CANSparkMax leftB;
    private CANSparkMax leftC;
    private CANSparkMax rightA;
    private CANSparkMax rightB;
    private CANSparkMax rightC;

    private SpeedControllerGroup left;
    private SpeedControllerGroup right;
    
    public Drive() {
        leftA = new CANSparkMax(RobotMap.LEFT_A_DRIVE_MOTOR, MotorType.kBrushless);
        leftB = new CANSparkMax(RobotMap.LEFT_B_DRIVE_MOTOR, MotorType.kBrushless);
        leftC = new CANSparkMax(RobotMap.LEFT_C_DRIVE_MOTOR, MotorType.kBrushless);

        rightA = new CANSparkMax(RobotMap.RIGHT_A_DRIVE_MOTOR, MotorType.kBrushless);
        rightB = new CANSparkMax(RobotMap.RIGHT_B_DRIVE_MOTOR, MotorType.kBrushless);
        leftC = new CANSparkMax(RobotMap.RIGHT_C_DRIVE_MOTOR, MotorType.kBrushless);

        left = new SpeedControllerGroup(leftA, leftB,leftC);
        right = new SpeedControllerGroup(rightA,rightB,rightC);            
    }

    @Override
    public void initDefaultCommand() { setDefaultCommand(new DriveCommand());}

    public void setLeft(double speed) { left.set(speed); }

    public void setRight(double speed) { right.set(speed); }

    public void stop() {
        left.set(0);
        right.set(0);
    }

}
