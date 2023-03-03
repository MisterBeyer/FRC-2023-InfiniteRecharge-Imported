// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.revrobotics.SparkMaxAlternateEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import com.revrobotics.CANSparkMax;

public class Move5Feet extends CommandBase {

  private final Drivebase m_subsystem;

  public Move5Feet(Drivebase subsystem) {
    m_subsystem = subsystem;
    m_subsystem.setIdleMode();
    addRequirements(m_subsystem);
   }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.setEncoder();
  //  m_subsystem.tankDrive(-.25, -.25);
    m_subsystem.getEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
    public void execute() {
      //nick is so great
      //but jaden is greater
  
      
      
      System.out.println(" phil swift");
      System.out.println("Encoder:" + m_subsystem.getEncoder());
    }
  //1 feet = 45 tick
  
//1 feet = 45 tick
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0);
    m_subsystem.setEncoder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return  m_subsystem.getEncoder() > 1;
  }
  //290 worked for charge station

    // m_subsystem.tankDrive(.35, .35);
    //nick is so great
    // double error =  0-m_subsystem.getEncoder();
    // double sumError =+ error;
    // // double power = error*0.4;
    // //  power = sumError + 0.0001;
    // double power = (error * 0.04)+(sumError * 0.001);

  //   if(power > 0.5){
  //     power = 0.5;
  //   }
  //   if(power < -0.5){
  //     power = -0.5;
  //   }
  //   if(sumError > 500){
  //       sumError = 500;
  //   }
  //   if(sumError < 500){
  //     sumError = -500;
  //   }
  //    power = (error * 0.04)+(sumError * 0.001);
  //    System.out.println(power);

  //   if ( m_subsystem.getEncoder() >  -.5 && m_subsystem.getEncoder() < .5) {
  //   m_subsystem.tankDrive(0, 0);
  // }
  //  else {
  //   m_subsystem.tankDrive(power, power);

  //  } 
    
    
//     System.out.println(" phil swift");
//     System.out.println("Encoder:" + m_subsystem.getEncoder());
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     m_subsystem.tankDrive(0, 0);
//     m_subsystem.setIdleMode();

//     m_subsystem.setEncoder();
//   }

//   // Returns true when the command should end.
//   @Override
//    public boolean isFinished() {
//      return  m_subsystem.getEncoder() < 100;
//  }
}
