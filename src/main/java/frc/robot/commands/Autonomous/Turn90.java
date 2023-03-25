// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands.Autonomous;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  Constants contant = new Constants();
  Drivebase drive;
  CANSparkMax front_Right;

  double gyro; 
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Turn90(Drivebase subsystem  ){
    this.drive = subsystem;
    addRequirements(subsystem);
  } 
   
  

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetGyro();


    System.out.println("Initialized");
    drive.setIdleMode();
    
  }
  
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    gyro = drive.getGyro();

    SmartDashboard.putNumber("yaw", gyro);
    double error =  -90 - gyro;
    SmartDashboard.putNumber("error", error);

    double sumError =+ error;
    double power = (error * contant.TurnP)+(sumError * contant.TurnI);
    
    power = MathUtil.clamp(power, -0.2, 0.2);
    sumError = MathUtil.clamp(sumError, -500, 500);  

    SmartDashboard.putNumber("power", power);
    drive.spin(-power,-power);
    
    }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sumError = 0;
    drive.spin(0, 0);
    // drive.setEncoder(); 
    drive.resetGyro();
    
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   return  (gyro >= 89)  && (gyro <= 91) || ((gyro <= -89) && ((gyro >= -91) ));    
  }
}
