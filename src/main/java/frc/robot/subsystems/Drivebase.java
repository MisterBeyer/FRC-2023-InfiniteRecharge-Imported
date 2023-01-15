package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class Drivebase extends SubsystemBase {
    private final CANSparkMax front_Left = new CANSparkMax(13, MotorType.kBrushless);
    private final CANSparkMax back_Left = new CANSparkMax(12, MotorType.kBrushless);
    private final CANSparkMax front_Right = new CANSparkMax(15, MotorType.kBrushless);
    private final CANSparkMax back_Right = new CANSparkMax(14, MotorType.kBrushless);
    MotorControllerGroup m_right = new MotorControllerGroup(front_Right, back_Right);
    MotorControllerGroup m_left = new MotorControllerGroup(front_Left, back_Left);


    // public Drivebase()
    // {
    //     back_Left.follow(front_Left);
    //     back_Right.follow(front_Right);
    // }

    public void tankDrive(double left_Input, double right_Input) {
        front_Left.set(left_Input);
        front_Right.set(right_Input);
        // m_left.set(left_Input);
        // m_right.set(right_Input);
        //front_Right.set(ControlMode.PercentOutput, right_Input);

    }
}