// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
public class Intake extends SubsystemBase {
  private Solenoid solenoide;
  private final CANSparkMax intakeMotor = new CANSparkMax(9999, MotorType.kBrushless);
  // private final CANSparkMax front_Left = new CANSparkMax(6, MotorType.kBrushless);

  /** Creates a new Intake. */
  public Intake() {

   this.solenoide = new Solenoid(PneumaticsModuleType.CTREPCM, 99999);
  }
  public void fowardAndBackward() {
   System.out.println(" the intake is in the up posiition  or the down position");
     solenoide.toggle();
  }
  //TODO make a if statment with motors that checks if its moving if movign the motor stops if not movign the motor spins 
  public void Motorforward(){
    System.out.println(" The Intake is on or off");
    intakeMotor.set(.5); 
 }
 public void Motorbackward(){
  intakeMotor.set(-.5);
 }
 public void MotorStop(){
  intakeMotor.set(0);
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
