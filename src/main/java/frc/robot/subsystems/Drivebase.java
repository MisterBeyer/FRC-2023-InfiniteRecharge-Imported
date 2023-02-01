package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class Drivebase extends SubsystemBase {
  Constants constant = new Constants();

    private final CANSparkMax front_Left = new CANSparkMax(1, MotorType.kBrushless);
    private final CANSparkMax back_Left = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax front_Right = new CANSparkMax(4, MotorType.kBrushless);
    private final CANSparkMax back_Right = new CANSparkMax(3, MotorType.kBrushless);

// TODO: create a speed limitor method that creates a speed limit verible that can be sent to example cammond
public void setSpeed(double speed) {
    
  }    
    public void tankDrive(double left_Input, double right_Input) {
        
       front_Left.set(left_Input );
        front_Right.set(right_Input );

        //front_Right.set(ControlMode.PercentOutput, right_Input);

    }
    public void auto() {
      front_Left.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 42).setPosition(500);

    }
}