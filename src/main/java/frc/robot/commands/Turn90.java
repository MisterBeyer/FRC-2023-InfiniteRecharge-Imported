// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;

import com.revrobotics.*;
import com.revrobotics.CANSparkMax.IdleMode;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** An example command that uses an example subsystem.
 */
public class Turn90 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  public double sumError;
  CANSparkMax front_Left;
  Constants contant;
  Drivebase drive;
  CANSparkMax front_Right;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Turn90(Drivebase subsystem  ){
    this.drive = subsystem;
  } 
   
  

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.setGyro();

    System.out.println("Initialized");
    drive.setIdleMode();
    
  }
  
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error =  90- 50;    //drive.getGyro();
    double sumError =+ error;
    double power = error*0.0004;
     power = sumError + 0.00001;
    System.out.println(error);
    if(power > 0.2){
      power = 0.2;
    }
    if(power < -0.2){
      power = -0.2;
    }
    if(sumError > 500){
        sumError = 500;
    }
    if(sumError < 500){
      sumError = -500;
    }
    drive.tankDrive(-power, -power);
    
    }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sumError = 0;
    drive.tankDrive(0, 0);
    // drive.setEncoder(); 
    drive.setGyro();
    
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
   //  (drive.getGyro() >= 84)  && (drive.getGyro() <= 86) || ((drive.getGyro() >= -84) && ((drive.getGyro() <= -86) ));
  return false;
  }
}
