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


public class IntakeMovements extends CommandBase {

  private Intake intake;
  private Drivebase drive;
  private ElevatorStart elevator;
  private Constants constant = new Constants();
  
  private BooleanSupplier in;
  private BooleanSupplier out;
  private BooleanSupplier on;
  private boolean resetTimer = true;
  private boolean gotGamepiece = false;
  private PowerDistribution powerDis;
  // private BooleanSupplier out;
  boolean Solenoid =  false;
  boolean Intake =  false;
  boolean Outake =  false;


  public IntakeMovements(
    Intake intake,
    Drivebase drive,
    ElevatorStart elevator,
    PowerDistribution powerDis,
    BooleanSupplier on,
    BooleanSupplier in,
    BooleanSupplier out
    // BooleanSupplier out
  ) {
    
  this.intake = intake;
  this.out = out; // spiin outtake
  this.drive = drive;
  this.elevator = elevator;
  this.powerDis = powerDis;
  this.on = on; // deploy 
  this.in = in; // spin intake
  // this.out = out; // spiin outtake

  addRequirements(this.intake);  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    boolean pressed =  false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("intakeCurrent", powerDis.getCurrent(14));
      
    boolean pressed =  false;
     // 25 is the current threshold for cube 
    

    if ( out.getAsBoolean() == true ){
      if ( intake.getSolenoideState() == true){
        intake.setSolenoideStateFalse();
      }
      else if (intake.getSolenoideState() == false) {
         intake.setSolenoideStateTrue();
      }
    }
    if ( in.getAsBoolean() == true){
      if ( powerDis.getCurrent(14) > constant.ampActivation  ) {
            // 25 is the current threshold for cube
            System.out.println("over threshold");
        gotGamepiece = true;
        intake.setSolenoideStateFalse();
        
        elevator.setSetPoint(constant.lowPos);
      }
      else {
       intake.Motorbackward();
       pressed = true;
       if ( resetTimer == true) {
        intake.timerReset();
        resetTimer = false;
         }
        }

    }
    if ( on.getAsBoolean() == true){
     intake.Motorforward();


      pressed = true;

    }

    if (intake.getSolenoideState() == true) {
      intake.forward();
    }
    else {
    
    intake.backwardd();
    }
  if ( pressed != true) {
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
