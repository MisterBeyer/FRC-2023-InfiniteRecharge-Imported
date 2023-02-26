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

/** An example command that uses an example subsystem.
 */
public class ElevatorPosition extends CommandBase {
  Constants constant = new Constants();

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private double setPoint = 0;
  private double prevError = 0;
  private double sumError = 0;
  private int count = 0;
  private ElevatorStart elevator;
  private BooleanSupplier bumperRight;
  private BooleanSupplier bumperLeft;
  private BooleanSupplier top;
  private BooleanSupplier medium;
  private BooleanSupplier bottom;
  private BooleanSupplier up;
  private BooleanSupplier down;
  private BooleanSupplier zero;
  private XboxController gamePad;
  private Deadband dead;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ElevatorPosition(
    ElevatorStart elevator,
    BooleanSupplier top,
    BooleanSupplier medium,
    BooleanSupplier bottom,
    BooleanSupplier up,
    BooleanSupplier down,
    BooleanSupplier zero
) {
    this.elevator = elevator;
    this.top = top;
    this.medium = medium;
    this.bottom = bottom;
    this.up = up;
    this.down = down;
    this.zero = zero;
    
    
    
    gamePad = new XboxController(0);
    constant = new Constants();
    


    addRequirements(this.elevator);
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   elevator.elevatorReset();
  }
  
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // double curPos = 0;

    // double error = 0;
    // double div = 0;
    // double power = 0;
    if(true == top.getAsBoolean())
    {
      double curPos = elevator.getLeftEncoder();

     double error = setPoint - curPos;
     double div = prevError - error;
     double power = (error * constant.ElevatorP)+(sumError * constant.ElevatorI);
    //+(div * constant.ElevatorD)+(sumError * constant.ElevatorI);

    prevError = error;
    sumError += error;
  
    sumError = MathUtil.clamp(sumError, 30, 30);
    power = MathUtil.clamp(power, -.2, .2);

    elevator.move(power);
      setPoint = constant.topPosition;
    }
    else
    {
      if(true == medium.getAsBoolean())
      {
         double curPos = elevator.getLeftEncoder();

     double error = setPoint - curPos;
     double div = prevError - error;
     double power = (error * constant.ElevatorP)+(sumError * constant.ElevatorI);
    //+(div * constant.ElevatorD)+(sumError * constant.ElevatorI);

    prevError = error;
    sumError += error;
  
    sumError = MathUtil.clamp(sumError, 30, 30);
    power = MathUtil.clamp(power, -.2, .2);

    elevator.move(power);
        setPoint = constant.medPosition;
      }
      else
      {
        if(true == bottom.getAsBoolean())
        {
          setPoint = 2 +  constant.zero;
        }
        else if ( true == up.getAsBoolean()){
          elevator.up();
      }
      else if ( true == down.getAsBoolean()){
        elevator.down();
    }
    else if ( true == zero.getAsBoolean()){
      elevator.encoderReset();
  }
  else {
    elevator.elevatorReset();
  }

      }
    }
    //System.out.println(elevator.getLeftEncoder());

    // double curPos = elevator.getLeftEncoder();

    // double error = setPoint - curPos;
    // double div = prevError - error;
    // double power = (error * constant.ElevatorP);
    // //+(div * constant.ElevatorD)+(sumError * constant.ElevatorI);

    // prevError = error;
    // sumError += error;
  
    // sumError = MathUtil.clamp(sumError, 10000, 10000);
    // power = MathUtil.clamp(power, -.2, .2);

    // elevator.move(power);
    //elevator.move(0);

    count++;
    if(0 == (count % 3))
    {
      //System.out.printf("TP:%8.1f CP:%8.1f E:%13.3f D:%13.3f SE:%15.3f P:%15.3f\n", setPoint, curPos, error, div, sumError, power);
    }
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   // elevator.encoderReset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
