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
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.math.*;

/** An example command that uses an example subsystem.
 */
public class ElevatorPosition extends CommandBase {
  Constants constant = new Constants();

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private double setPoint = constant.lowPos;
  private double prevError = 0;
  private double sumError = 0;
  private int count = 0;
  private ElevatorStart elevator;
  private Intake intake;
  private PowerDistribution powerDis;
  private BooleanSupplier bumperRight;
  private BooleanSupplier bumperLeft;
  private BooleanSupplier top;
  private BooleanSupplier medium;
  private BooleanSupplier bottom;
  private BooleanSupplier up;
  private BooleanSupplier down;
  private BooleanSupplier zero;
  private boolean m_down;
  private boolean m_top;

  private XboxController gamePad;
  private Deadband dead;
//  private Intake intake;

  private boolean pressed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ElevatorPosition(
    ElevatorStart elevator,
    Intake intake,
    PowerDistribution powerDis,
    BooleanSupplier top,
    BooleanSupplier medium,
    BooleanSupplier bottom,
    BooleanSupplier up,
    BooleanSupplier down,
    BooleanSupplier zero
) {
    this.elevator = elevator;
    this.intake = intake;
    this.powerDis = powerDis;
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
   elevator.brake();
   setPoint = constant.lowPos;
   elevator.elevatorReset();
   //elevator.encoderReset();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double[] ar = { 2,3,1};
    //System.out.println(bottom.getAsBoolean());
    SmartDashboard.putNumber("elevatorCurrentLeft", powerDis.getCurrent(1));
    SmartDashboard.putNumber("elevatorCurrentRight", powerDis.getCurrent(2));
    SmartDashboard.putNumberArray("testtttt", ar);
    // double curPos = 0;
    // double error = 0;
    // double div = 0;
    // double power = 0;
    if(true == top.getAsBoolean())
    {
    // System.out.println(" top has been called");
    elevator.setSetPoint(constant.topPosition);
  }
    else
    {
      if(true == medium.getAsBoolean())
      {
        elevator.setSetPoint(constant.medPosition);
        intake.forward();
      }
      else
      {
        if(true == bottom.getAsBoolean())
        {
          //intake.backwardd();
          elevator.setSetPoint(constant.lowPos);

          // setPoint = 2 +  constant.zero;
        }
        else if ( true == up.getAsBoolean()){
          //System.out.println(setPoint);
          elevator.setSetPoint(elevator.getSetPoint() + .3);
        }
      else if ( true == down.getAsBoolean()){
        //System.out.println(setPoint);
        elevator.setSetPoint(elevator.getSetPoint() - .3);

      }
    else if ( true == zero.getAsBoolean()){
      elevator.encoderReset();
  }
  else {
    //System.out.println(" set Point " + setPoint);
    //elevator.elevatorReset();
  }
 // elevator.ShowVolts();

      }
    }

    count++;
    
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.encoderReset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
