// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Deadband;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem.
 */
public class ExampleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivebase m_subsystem;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  private XboxController gamePad;
  private Deadband dead;
  private static double x;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(Drivebase subsystem, DoubleSupplier left, DoubleSupplier right) {
    m_subsystem = subsystem;
    
    m_left = left;
    m_right = right;
    
    gamePad = new XboxController(0);
    dead = new Deadband();
    // Use addRequirements() here to declare subsystem dependencies.
    // addRequirements(subsystem);
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Joystickx = m_left.getAsDouble();
    double Joysticky = m_right.getAsDouble();
    m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, .15) * 1, x * dead.deadBand(Joysticky, .15));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
