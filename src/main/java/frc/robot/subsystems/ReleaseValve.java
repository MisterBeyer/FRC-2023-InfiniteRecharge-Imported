// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ReleaseValve extends SubsystemBase {
  private Solenoid release;
  private boolean button1;
  private boolean button2;

  /** Creates a new ReleaseValve. */
  public ReleaseValve() {
    boolean button1 = false;
    boolean button2 = false;
    release = new Solenoid(PneumaticsModuleType.CTREPCM,4);

  }
  // public boolean safety1() {
  //   button1 = !button1;
  //   return button1;
  // }
  // public boolean safety2() {
  //   button2 = !button2;
  //   return button2;
 // }
  public void shoot(){
    //  Lilys for loop only thing she ever done in her life 
    
      release.toggle();}
    

  
    

  // public void on(){
  //   if ( release.get() == true) {
  //     release.toggle();
  //     System.out.println("Release close  went off ");
  //   }
  // }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
