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
public class Move10Feet extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  CANSparkMax front_Left;
  Constants contant;
  Drivebase drive;
  CANSparkMax front_Right;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Move10Feet(Drivebase subsystem  ){
    this.drive = subsystem;
  } 
   
  

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Initialized");
    drive.tankDrive(.3, .3);
  }
  
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.displayEncoder();
    }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    drive.tankDrive(0, 0);
    drive.setEncoder(); 

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return drive.getEncoder() > 100;
  }
}
