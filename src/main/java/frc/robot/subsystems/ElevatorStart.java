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
  Constants constant = new Constants();
  private double zero = .5;
  private double p = constant.ElevatorP;
  private final CANSparkMax leftMotor = new CANSparkMax(constant.elevatorLeftMotor , MotorType.kBrushless);
 private final CANSparkMax rightMotor = new CANSparkMax(constant.elevatorRightMotor, MotorType.kBrushless);


 // 0 = bottom 50 = medium 100 = high
 public ElevatorStart() {
  rightMotor.setInverted(true);
  leftMotor.getEncoder().setPosition(0);
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
   }
   
   public void elevatorZero() {
    zero = leftMotor.getEncoder().getPosition();

   }

   public void encoderValue() {
    System.out.println(leftMotor.getEncoder().getPosition());
   }
   
   public double getLeftEncoder() {
    System.out.println(leftMotor.getEncoder().getPosition());

    return leftMotor.getEncoder().getPosition();

   }
   public void encoderReset(){
    leftMotor.getEncoder().setPosition(0);
    rightMotor.getEncoder().setPosition(0);

   }
   public void elevatorReset() {
    leftMotor.set(0);
    rightMotor.set(0);
    
    // leftMotor.getEncoder().setPosition(0);
    // rightMotor.getEncoder().setPosition(0);
   }
   // max height PID = 13.1
   // top = 13.4
   // middle = 7
   // bottom = 0 
   public void fancyZero() {
     leftMotor.set(-.05);
     if ( leftMotor.getBusVoltage() < 5 && leftMotor.getBusVoltage() > 8)
     {
    zero = leftMotor.getEncoder().getPosition();
    leftMotor.set(0);

     }
   }
   public void topPositionII(){
    double error =  96-leftMotor.getEncoder().getPosition();
    double power = error*p;
    if(power > 0.10){
      power = 0.10;
    }
    if(power < -0.10){
      power = -0.10;
    }   
    leftMotor.set(power);
    rightMotor.set(power);

   }
   public void topPosition(){
 
    if (leftMotor.getEncoder().getPosition() > 95 && leftMotor.getEncoder().getPosition() < 100) {
     leftMotor.set(0);
     rightMotor.set(0);
    }
    else {
      leftMotor.set(.1);
      rightMotor.set(.1);
    }

    }
    public void up() {
      leftMotor.set(.2);
      rightMotor.set(.2);
    }
    public void down() {
      leftMotor.set(-.2);
      rightMotor.set(-.2);
    }
    public void mediumPosition(){
      System.out.println(leftMotor.getEncoder().getPosition());
      if (leftMotor.getEncoder().getPosition() > 40 && leftMotor.getEncoder().getPosition() < 45) {
        leftMotor.set(0);
       rightMotor.set(0);
       }
       else if (leftMotor.getEncoder().getPosition() > 53) {
         leftMotor.set(-.5);
        rightMotor.set(-.5);
       }
       else{
        leftMotor.set(.5);
         rightMotor.set(.5);
       }
      // front_Left.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 42).setPosition(0);
      //  front_Left.set(.90);
     
      }
      public void bottomPosition(){
        if (leftMotor.getEncoder().getPosition() > zero && leftMotor.getEncoder().getPosition() < zero + 3) {
          leftMotor.set(0);
          rightMotor.set(0);
         }
         else {
           leftMotor.set(-.1);
           rightMotor.set(-.1);
         }

        System.out.println(" Elevator is at bottom position");
       
        }
        public void move(double power) {
      
         leftMotor.set(power );
         rightMotor.set(power );
            
       }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
