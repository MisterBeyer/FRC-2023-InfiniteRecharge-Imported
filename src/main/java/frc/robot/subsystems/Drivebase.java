package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
    private final VictorSPX front_Left = new VictorSPX(3);
    private final VictorSPX back_Left = new VictorSPX(1);
    private final VictorSPX front_Right = new VictorSPX(11);
    private final VictorSPX back_Right = new VictorSPX(7);

    public Drivebase()
    {
        back_Left.follow(front_Left);
        back_Right.follow(front_Right);
    }

    public void tankDrive(double left_Input, double right_Input) {
        front_Left.set(ControlMode.PercentOutput, left_Input);
        front_Right.set(ControlMode.PercentOutput, right_Input);

    }
}