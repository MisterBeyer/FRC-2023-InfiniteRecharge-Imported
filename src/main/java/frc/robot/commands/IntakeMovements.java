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
  private ElevatorPosition elevator;

  
  private BooleanSupplier in;
  private BooleanSupplier out;
  private BooleanSupplier on;
  private PowerDistribution powerDis;
  // private BooleanSupplier out;
  boolean Solenoid =  false;
  boolean Intake =  false;
  boolean Outake =  false;


  public IntakeMovements(
    Intake intake,
    Drivebase drive,
    ElevatorPosition elevator,
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
    if (powerDis.getCurrent(14) > 25 ) {
       intake.backwardd();
       elevator.setPoint0(.5);
     // intake.timeStart();
      if ( powerDis.getCurrent(14) > 25 && intake.timeGet() > .9) {
        // Joe Biden disapproves of this code 
        //elevator.setPoint0(0);
      }
    }

    if ( out.getAsBoolean() == true){
    //intake.forward();
    Solenoid = !Solenoid;
    }
    if ( in.getAsBoolean() == true){
          intake.Motorbackward();

      // Intake = !Intake;
      // Outake = !Outake;
      pressed = true;

    }
    if ( on.getAsBoolean() == true){
     intake.Motorforward();

     //Intake = !Intake;

      pressed = true;

    }

    if (Solenoid == true) {
      intake.forward();
    }
    else {
      
    intake.backwardd();
    }
    // if (Outake == true) {
    //   intake.Motorbackward();
    // }
    // else if (Intake == true) {
    //   intake.Motorforward();
    // }
    
  //   else {
  //     intake.slowIntake();
  //  }
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
