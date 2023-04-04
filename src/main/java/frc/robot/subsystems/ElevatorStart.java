// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import java.util.Timer;

import java.util.function.DoubleSupplier;

import javax.sound.sampled.LineEvent.Type;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class ElevatorStart extends SubsystemBase {
  Constants constant = new Constants();
  private double setPoint = constant.lowPos;
  private double sumError = 0;
  private final CANSparkMax leftMotor = new CANSparkMax(constant.elevatorLeftMotor , MotorType.kBrushless);
 private final CANSparkMax rightMotor = new CANSparkMax(constant.elevatorRightMotor, MotorType.kBrushless);
  private Timer time = new Timer();

 // 0 = bottom 50 = medium 100 = high
 public ElevatorStart() {
 System.out.println("ElevatorStart Created");
  rightMotor.setInverted(true);
  leftMotor.getEncoder().setPosition(0);
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
   }
   public double time() {
    return time.get();
   }

public IdleMode getState() {
 return leftMotor.getIdleMode();
}
public void brake() {
   leftMotor.setIdleMode(IdleMode.kBrake);
   rightMotor.setIdleMode(IdleMode.kBrake);
}
public void coast() {
  leftMotor.setIdleMode(IdleMode.kCoast);
  rightMotor.setIdleMode(IdleMode.kCoast);
}

   
   public void ShowVolts() {
    System.out.println("Left Current; " +  leftMotor.getOutputCurrent() );

   System.out.println("Right Current; " +  rightMotor.getOutputCurrent() );

  }
   
   public void encoderValue() {
    //System.out.println(leftMotor.getEncoder().getPosition());
   }
   
   public double getLeftEncoder() {
    //System.out.println(leftMotor.getEncoder().getPosition());
    

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
   
   
    public void up() {
      leftMotor.set(.2);
      rightMotor.set(.2);
    }
    public double getSpeed() {
      return leftMotor.get();
    }
    public void down() {
      leftMotor.set(-.2);
      rightMotor.set(-.2);
    }
        public void move(double power) {
        //System.out.println(leftMotor.getEncoder().getPosition());
         leftMotor.set(power );
         rightMotor.set(power );
            
       }
       public void setSetPoint(double wantedSetPoint){
        setPoint = wantedSetPoint;
       }
       public double getSetPoint(){
        return setPoint;
       }
       public double ThreshHoldInterpolatb( double error) {
    
        double power = constant.elevatorMaxSpeed;
        if ( Math.abs(error) < constant.elevatorErrorThresh)
       {
          double t = Math.abs(error)/constant.elevatorErrorThresh;
          power = MathUtil.interpolate(constant.elevatorMinSpeed, constant.elevatorMaxSpeed, t);
       }
        
        return power;
      }
      public double PID(double setPoint) {
        double curPos = getLeftEncoder();
        double error = setPoint - curPos;
    
        sumError += error;
        //double div = prevError - error;
        double power = (error * constant.ElevatorP)+(sumError * constant.ElevatorI);
       //+(div * constant.ElevatorD)+(sumError * constant.ElevatorI);
    
       // TODO test out what happens if we change low to a negative during summer
     
       sumError = MathUtil.clamp(sumError, 30, 30);
       double clampPower = ThreshHoldInterpolatb(error);
       power = MathUtil.clamp(power, -clampPower, clampPower);
       
      
       return power;
        
      }
      


  @Override
  public void periodic() {
   setPoint = MathUtil.clamp(setPoint, constant.lowPos, constant.maxSetPoint);
   move(PID(setPoint));
   SmartDashboard.putNumber("elevator Encoder", getLeftEncoder());

  }
}
