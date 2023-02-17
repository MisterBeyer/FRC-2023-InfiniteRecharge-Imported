// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Deadband;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem.
 */
public class ExampleCommand extends CommandBase {
  Constants constant = new Constants();

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivebase m_subsystem;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  private BooleanSupplier bumperRight;
  private BooleanSupplier bumperLeft;
  private XboxController gamePad;
  private Deadband dead;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(
    Drivebase subsystem, 
    DoubleSupplier left, 
    DoubleSupplier right,
    BooleanSupplier bumperRight,
    BooleanSupplier bumperLeft
) {
    m_subsystem = subsystem;
    this.bumperRight = bumperRight;
    this.bumperLeft = bumperLeft;
    this.m_left = right;
    this.m_right = left;
    
    gamePad = new XboxController(0);
    dead = new Deadband();
    double slowsModifier = constant.slowSpeed;
    double mediumModifier = constant.mediumSpeed;


    addRequirements(subsystem);
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
  
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double slowsModifier = constant.slowSpeed;
    double mediumModifier = constant.mediumSpeed;
    double deadBand = constant.deadband;
    double Joystickx = this.m_left.getAsDouble();
    double Joysticky = this.m_right.getAsDouble();
        // System.out.print("this is x " + Joystickx);
        // System.out.println(" " + Joysticky);

    if ( true == bumperLeft.getAsBoolean()) {
      m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * slowsModifier, -slowsModifier * dead.deadBand(Joysticky, deadBand));

    }
    else if ( true == bumperRight.getAsBoolean()){
      m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * 1, -1* dead.deadBand(Joysticky, deadBand));

    }
    else {
    m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * mediumModifier, -mediumModifier* dead.deadBand(Joysticky, deadBand));
    }
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
