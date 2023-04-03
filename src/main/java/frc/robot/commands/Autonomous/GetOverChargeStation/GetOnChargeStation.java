// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.GetOverChargeStation;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.revrobotics.SparkMaxAlternateEncoder;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;
import com.revrobotics.CANSparkMax;

public class GetOnChargeStation extends CommandBase {
  private double setPoint = 0;
  private double prevError = 0;
  public double timer;
  private double sumError = 0;
  private int count = 0;
  private final Drivebase m_subsystem;
  private Constants constant = new Constants();

  public GetOnChargeStation(Drivebase subsystem) {
   m_subsystem = subsystem;
   m_subsystem.setIdleMode();
   addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    
   SmartDashboard.putNumber("degree", m_subsystem.degree());

   double curPos = m_subsystem.degree();
    double error = setPoint - curPos;

    prevError = error;
    sumError += error;
    SmartDashboard.putNumber("erro", error);
    SmartDashboard.putNumber("sumerro", sumError);



    //double div = prevError - error;
    double power = (error * constant.chargeP )+(sumError * constant.chargeI);
   //+(div * constant.ElevatorD)+(sumError * constant.ElevatorI);

   SmartDashboard.putNumber("power", power);

 
   sumError = MathUtil.clamp(sumError, -30, 30);
   //double clampPower = ThreshHoldInterpolatb(error);
   power = MathUtil.clamp(power, -.2, .2);
   
   System.out.println("power; " + power );
   System.out.println("error; " + error );

  //  if ( m_subsystem.degree() > .5 && m_subsystem.degree() < -.5 )
  //   {
  //    timer = m_subsystem.time();
  //   }

   m_subsystem.move(-power);
  }
//1 feet = 45 tick
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.tankDrive(0, 0);
    m_subsystem.setEncoder();
    m_subsystem.timeReset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    //m_subsystem.degree() > .5 && m_subsystem.degree() < -.5 && timer > 1;
  }
  // 250 got over cleanly 
  // - 550 to get cleanly over
  //800 ticks to get to the first game objects
  //-308 worked for charge station
}
