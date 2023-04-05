// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorStart;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;

public class AutoElevatorDown extends CommandBase {
  private Intake m_Intake;
  private ElevatorStart cool;
  private Constants constant = new Constants();
  /** Creates a new AutoElevatorDown. */
  public AutoElevatorDown(ElevatorStart elevator, Intake intake) {
    
    
      m_Intake = intake;
      cool = elevator;

     addRequirements(cool, m_Intake);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.backwardd();
    cool.setSetPoint(constant.lowPos);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return cool.getLeftEncoder() < constant.lowPos + .1;
  }
}
