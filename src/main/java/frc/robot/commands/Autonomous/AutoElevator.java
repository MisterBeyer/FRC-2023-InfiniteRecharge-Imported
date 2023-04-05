// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import java.util.Timer;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorStart;
import frc.robot.subsystems.Intake;


public class AutoElevator extends CommandBase {
  private ElevatorStart cool;
  private Intake m_Intake;
  private Constants constant = new Constants();
  private double setPoint = 0;
  private double prevError = 0;
  private double sumError = 0;
  private final Timer time = new Timer(); 

  Boolean elevatorComplete = false;
  Boolean timerComplete = false;
 

  private int count = 0;
    public AutoElevator( ElevatorStart elevator, Intake intake ) 
    {
      m_Intake = intake;
      cool = elevator;

     addRequirements(cool, m_Intake);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    cool.encoderReset();
    cool.setSetPoint(constant.autoCube);
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println(" phil swift");
    System.out.println("Encoder:" + cool.getLeftEncoder());
    System.out.println("Speed:" + cool.getSpeed());


}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {   
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return  cool.getLeftEncoder() > constant.autoCube -.1;
}
}
