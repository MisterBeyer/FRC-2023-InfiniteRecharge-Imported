// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.concurrent.Delayed;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ReleaseValve;

public class Shoot extends CommandBase {
  private ReleaseValve ooga;
  /* Creates a new release. */
  public Shoot() {
    ooga = new ReleaseValve();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override

    
  
  public void initialize() {
    //Lily's 2nd for loop!!! so amazing!!! :DDDDD XD X3 IF SOMETHING GOES WRONG WITH SHOOTIN LOOK AT THE FOR LOOP
     // ooga.shoot(); 

    

    // if ( ooga.safety1() == true) {
    //   System.out.println(" safety 1 is on");
    //   if (ooga.safety2() == true) {
    //     System.out.println(" safety 2 is on");

    //     for(int i = 1; i <= 2; i++) {
    //       ooga.shoot();
    //     }
    //   }
    //   else { ooga.safety1();
    //   }

    // }
    // else { ooga.safety2();
    // }
    
  

  }

   // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ooga.shoot(); 
System.out.println("off started");
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return true;
  }
}
