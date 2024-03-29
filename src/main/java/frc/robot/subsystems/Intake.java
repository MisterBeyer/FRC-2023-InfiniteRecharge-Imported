// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PowerDistribution;

import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.sensors.WPI_Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import frc.robot.Constants;
import frc.robot.commands.Autonomous.IntakeMotor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;
public class Intake extends SubsystemBase {
  private Solenoid solenoide;
  private Timer time;
  private boolean solenoidOn = false;
 // PowerDistribution powerDis = new PowerDistribution(18, ModuleType.kCTRE);
 // private PneumaticsControlModule pcm;
  private final CANSparkMax intakeMotor = new CANSparkMax(7, MotorType.kBrushless);
  //private final CANSparkMax front_Left = new CANSparkMax(6, MotorType.kBrushless);

  /** Creates a new Intake. */
  public Intake() {
    // this.powerDis = PowerDistribution(18, ModuleType.kCTRE);
    this.time = new Timer();
    intakeMotor.setIdleMode(IdleMode.kBrake);
    this.solenoide = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
   Constants constant = new Constants();
  // this.pcm = pcm;
  //this.solenoide = new Solenoid(PneumaticsModuleType.CTREPCM, 11);
  }
  public void forward() {
  // System.out.println(" the intake is in the up posiition  or the position");
   
    solenoide.set(true);
   
  }
  public boolean getSolenoideState(){
    return solenoidOn;
  }
  public void setSolenoideStateTrue(){
    solenoidOn = true;
  }
  public void setSolenoideStateFalse(){
    solenoidOn = false;
  }
  
  public void timeStart( ){
    time.start();
  }
  public void timerReset() {
    time.restart();
  }
  public double timeGet( ){
    return time.get();
  }
  public void backwardd() {
   // System.out.println(" the intake is in the posiition  or the down position");
    
     solenoide.set(false);
   }
  
public double intakeEncoder() {
  return .2;
//return intakeMotor.getEncoder().getPosition();
}

public void intakeReset() {
 intakeMotor.getEncoder().setPosition(0);
}

  public void Motorforward(){
  //  System.out.println(" The Intake is on or off");
     intakeMotor.set(.7); 
 }
 public void Motorbackward(){
   intakeMotor.set(-.7);
 }
 public void MotorStop(){
   intakeMotor.set(0);
 }
 public void slowIntake(){
  intakeMotor.set(-.05);
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
