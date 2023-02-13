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
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ElevatorStart extends SubsystemBase {
  private final CANSparkMax leftMotor = new CANSparkMax(99999, MotorType.kBrushless);
 private final CANSparkMax rightMotor = new CANSparkMax(999999, MotorType.kBrushless);


 // 0 = bottom 50 = medium 100 = high
 public ElevatorStart() {
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
   }
   public void topPositionII(){
    double error =  96-leftMotor.getEncoder().getPosition();
    double power = error*0.0004;
    if(power > 0.2){
      power = 0.2;
    }
    if(power <= -0.2){
      power = -0.2;
    }   
    leftMotor.set(power);
    rightMotor.set(power);

   }
   public void topPosition(){
    double error =  96-leftMotor.getEncoder().getPosition();
    double power = error*0.0004;
    


    if (leftMotor.getEncoder().getPosition() > 95 && leftMotor.getEncoder().getPosition() < 100) {
     leftMotor.set(0);
     rightMotor.set(0);
    }
    else {
      leftMotor.set(.25);
      rightMotor.set(.25);
    }
    // System.out.println(" Elevator is at top position");
   
    }
    public void mediumPosition(){
      if (leftMotor.getEncoder().getPosition() > 47 && leftMotor.getEncoder().getPosition() < 53) {
        leftMotor.set(0);
        rightMotor.set(0);
       }
       else if (leftMotor.getEncoder().getPosition() > 53) {
         leftMotor.set(-.25);
         rightMotor.set(-.25);
       }
       else{
        leftMotor.set(.25);
         rightMotor.set(.25);
       }
      // front_Left.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 42).setPosition(0);
      //  front_Left.set(.90);
      System.out.println(" Elevator is at medium position");
     
      }
      public void bottomPosition(){
        if (leftMotor.getEncoder().getPosition() > 0 && leftMotor.getEncoder().getPosition() < 5) {
          leftMotor.set(0);
          rightMotor.set(0);
         }
         else {
           leftMotor.set(-.25);
           rightMotor.set(-.25);
         }

        System.out.println(" Elevator is at bottom position");
       
        }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
