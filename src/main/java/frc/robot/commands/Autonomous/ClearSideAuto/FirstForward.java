// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.ClearSideAuto;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.revrobotics.SparkMaxAlternateEncoder;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;

public class FirstForward extends CommandBase {
  private PowerDistribution powerDis;
  private final Drivebase m_subsystem;
  private Intake intake;
  public FirstForward(Drivebase subsystem, Intake intake, PowerDistribution powerDis) {
    this.powerDis = powerDis;
   m_subsystem = subsystem;
   this.intake = intake;
   m_subsystem.setIdleMode();
   addRequirements(m_subsystem,intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.setEncoder();
    m_subsystem.move(.35);
    m_subsystem.getEncoder();
    intake.Motorbackward();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //nick is so great
// bu allision sucks
     if ( m_subsystem.getEncoder() > 700){
      m_subsystem.move(0);
      intake.MotorStop();
     }
    
     intake.forward();
    
    System.out.println(" phil swift");
    System.out.println("Encoder:" + m_subsystem.getEncoder());
  }
//1 feet = 45 tick
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0);
    m_subsystem.setEncoder();
    intake.backwardd();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return powerDis.getCurrent(14) > 27;
  }
  // 250 got over cleanly 
  // - 550 to get cleanly over
  //800 ticks to get to the first game objects
  //-308 worked for charge station
}
