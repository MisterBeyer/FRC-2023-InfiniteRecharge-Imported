// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import javax.sound.sampled.LineEvent.Type;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ElevatorStart extends SubsystemBase {
  private final CANSparkMax motor = new CANSparkMax(6, MotorType.kBrushless);
 private final CANSparkMax front_Left = new CANSparkMax(5, MotorType.kBrushless);

  /** Creates a new Motor. */
   public ElevatorStart() {
   }

   public void motorStart(){
    front_Left.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 42).setPosition(0);
     front_Left.set(.90);
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
