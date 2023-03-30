// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Deadband;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

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
  private final PowerDistribution power;

  private BooleanSupplier bumperRight;
  private BooleanSupplier bumperLeft;
  private XboxController gamePad;
  private Deadband dead;
  private double req = 0;
  private double currentent = 0;

  private double delta = 0;

  private double rampLeft = 0;
  private double rampRight = 0;

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
    power = new PowerDistribution();
    gamePad = new XboxController(0);
    dead = new Deadband();
    double slowsModifier = constant.slowSpeed;
    double mediumModifier = constant.mediumSpeed;

    addRequirements(subsystem);
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_subsystem.setBrake();
  }
  
  public double rampFunction(double requested, double current) {
  //   req = requested; // from joystick -1 to 1
  //   double outPut = 0.0;
  //   delta = .01; // max change to speed
    
  //   //currentent = m_subsystem.RightGetSpeed(); // currentent motor voltage, -1 to 1
  // if (req > 0 && current > 0) {
  //   if( req > current) {
  //     if (current + delta > req) {
	//       outPut = req;
  //     }
  //     else {
  //       outPut = current + delta;
  //     }
  //   }
  //   else {
  //     outPut = req;
  //   }
  // }
  // req -1
  // current -.5 - -.75
  // else if (req < 0 && current < 0){
  //   if (req < current) {
  //     if (current - delta < req) {
  //       outPut = current - delta;
  //     }
  //     else {
  //       outPut = req;
  //     }
  //   }
  //   else {
  //     outPut = req;
  //   }
  // }
  // else { // signs are opposite
  //   outPut = 0;
  // }
  // System.out.println(" outPut; " + outPut);
  return 2;

  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //System.out.println(m_subsystem.getEncoder());
    double slowsModifier = constant.slowSpeed;
    double mediumModifier = constant.mediumSpeed;
    double deadBand = constant.deadband;
    SmartDashboard.putNumber("encoder", m_subsystem.getEncoder());
    //SmartDashboard.putNumber("amp", power.getCurrent(1));

    double Joystickx = this.m_left.getAsDouble();
    double Joysticky = this.m_right.getAsDouble();
    
    // rampLeft = rampFunction(Joystickx, rampLeft);
    // rampRight = rampFunction(Joystickx, rampRight);
   


    if ( true == bumperLeft.getAsBoolean()) {

      m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * slowsModifier, -slowsModifier * dead.deadBand(Joysticky, deadBand));

    }
    else if ( true == bumperRight.getAsBoolean()){
      m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * 1, -1* dead.deadBand(Joysticky, deadBand));

    }
    else {
      //ystem.out.println(speedLeft);
    m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * mediumModifier, -.40* dead.deadBand(Joysticky, deadBand));
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
