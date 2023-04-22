// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Deadband;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.math.MathUtil;
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
  private double setPoint = 0;
  private double prevError = 0;
  public double timer;
  private double sumError = 0;
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivebase m_subsystem;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  private final PowerDistribution power;

  private BooleanSupplier bumperRight;
  private BooleanSupplier bumperLeft;
  private BooleanSupplier pid;
  private XboxController gamePad;
  private Deadband dead;
  private double req = 0;
  private double currentent = 0;

  private double delta = 0;

  private double rampLeft = 0;
  private double rampRight = 0;
  private double driveP = constant.chargeP;
  private double driveI = constant.chargeI;
  private double driveD = constant.chargeD;

  private double div;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(
    Drivebase subsystem, 
    DoubleSupplier left, 
    DoubleSupplier right,
    BooleanSupplier pid,
    BooleanSupplier bumperRight,
    BooleanSupplier bumperLeft
) {
   
    m_subsystem = subsystem;
    this.bumperRight = bumperRight;
    this.bumperLeft = bumperLeft;
    this.pid = pid;
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
    SmartDashboard.putNumber("driveI", constant.chargeI);
    SmartDashboard.putNumber("driveD", constant.chargeD);

    SmartDashboard.putNumber("driveP", constant.chargeP);

    
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    driveP = SmartDashboard.getNumber("driveP", constant.chargeP);
    driveI = SmartDashboard.getNumber("driveI", constant.chargeI);
    driveD = SmartDashboard.getNumber("driveI", constant.chargeD);


    //System.out.println(m_subsystem.getEncoder());
    double slowsModifier = constant.slowSpeed;
    double mediumModifier = constant.mediumSpeed;
    double deadBand = constant.deadband;
    SmartDashboard.putNumber("encoder", m_subsystem.getEncoder());
    //SmartDashboard.putNumber("amp", power.getCurrent(1));

    double Joystickx = this.m_left.getAsDouble();
    double Joysticky = this.m_right.getAsDouble();
    
  
    if ( true == bumperLeft.getAsBoolean()) {

      m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * slowsModifier, -slowsModifier * dead.deadBand(Joysticky, deadBand));

    }
    else if ( true == bumperRight.getAsBoolean()){
      m_subsystem.tankDrive(-1 * dead.deadBand(Joystickx, deadBand) * 1, -1* dead.deadBand(Joysticky, deadBand));

    }
     else if( true == pid.getAsBoolean()) {
      
      double curPos = m_subsystem.degree();
      double error = setPoint - curPos;
      if( error > -10 && error < 10) {
        m_subsystem.move(0);
      } 
      else{
      prevError = error;
      sumError += error;
      SmartDashboard.putNumber("erro", error);
      SmartDashboard.putNumber("sumerro", sumError);
      double div = prevError - error;
      sumError = MathUtil.clamp(sumError, -15, 15);
      double power = (error * driveP)+(sumError * driveI)+(div * driveD);
      

     SmartDashboard.putNumber("power", power);
  
   
    // sumError = MathUtil.clamp(sumError, -15, 15);
     power = MathUtil.clamp(power, -.3, .3);

     m_subsystem.move(-power);
      } 
    }
    else {
      //System.out.println(speedLeft);
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
