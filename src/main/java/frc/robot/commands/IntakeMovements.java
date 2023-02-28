// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Deadband;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ElevatorStart;
import frc.robot.subsystems.Intake;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


public class IntakeMovements extends CommandBase {

  private Intake intake;
  private BooleanSupplier in;
  private BooleanSupplier out;
  private BooleanSupplier on;
  // private BooleanSupplier out;

  public IntakeMovements(
    Intake intake,
    BooleanSupplier on,
    BooleanSupplier in,
    BooleanSupplier out
    // BooleanSupplier out
  ) {
    
  this.intake = intake;
  this.on = on;
  this.in = in;
  this.out = out;

  addRequirements(this.intake);  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ( in.getAsBoolean() ==true){
     intake.Motorforward();
    }
    else if  ( out.getAsBoolean() == true) {
      intake.fowardAndBackward();

      //intake.Motorbackward();
    }
    // else if ( on.getAsBoolean() == true){
    //   intake.fowardAndBackward();
    // }
    else {
intake.slowIntake();
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.MotorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
