// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeMotor extends CommandBase {
private Intake m_Intake;

  public IntakeMotor(Intake intake) {

    m_Intake = intake;
addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Intake.timeStart();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.forward();
    if (m_Intake.timeGet() > 2 ){
    
    m_Intake.Motorforward();
  }
     }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
   // intake.MotorStop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_Intake.timeGet() > 3;
  }
}
