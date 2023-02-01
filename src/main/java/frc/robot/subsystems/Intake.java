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
  private final CANSparkMax front_Left = new CANSparkMax(1, MotorType.kBrushless);
  // private final CANSparkMax front_Left = new CANSparkMax(6, MotorType.kBrushless);

  /** Creates a new Intake. */
  public Intake() {

   this.solenoide = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  }
  public void upAndDown() {

     solenoide.toggle();
  }
  public void Motor(){
front_Left.set(.5); 
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
