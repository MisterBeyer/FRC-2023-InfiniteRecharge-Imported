// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Deadband;
import frc.robot.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ElevatorStart;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


public class ElevatorManual extends CommandBase {

  private ElevatorStart elevator;
  private BooleanSupplier in;
  private BooleanSupplier out;

  public ElevatorManual(
    ElevatorStart elevator,
    BooleanSupplier in,
    BooleanSupplier out
  ) {
    
  this.elevator = elevator;
  this.in = in;
  this.out = out;

  addRequirements(this.elevator);  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.encoderValue();
    if ( in.getAsBoolean() == true){
      elevator.up();
      elevator.encoderValue();

    }
    else if  ( out.getAsBoolean() == true) {
      elevator.down();
      elevator.encoderValue();

    }
    else {
      elevator.elevatorReset();
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
