// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorStart;

public class AutoElevator extends CommandBase {
  private ElevatorStart elevator;
  private Constants constant;
  private double setPoint = 0;
  private double prevError = 0;
  private double sumError = 0;
  private int count = 0;
    public AutoElevator( ElevatorStart elevator ) 
    {
      this.elevator = elevator;
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    setPoint = 14;
    double curPos = elevator.getLeftEncoder();
    double error = setPoint - curPos;

    prevError = error;
    sumError += error;
    //double div = prevError - error;
    double power = (error * constant.ElevatorP)+(sumError * constant.ElevatorI);
   //+(div * constant.ElevatorD)+(sumError * constant.ElevatorI);

   
 
   sumError = MathUtil.clamp(sumError, 30, 30);
   power = MathUtil.clamp(power, -.2, .2);

   elevator.move(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if ( elevator.getLeftEncoder() > 0){
      elevator.move(-.5);

    }
    else { elevator.move(0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return elevator.getLeftEncoder() == 10;
  }
}
