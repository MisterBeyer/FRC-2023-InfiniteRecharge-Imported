// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class Piston extends SubsystemBase {
 public static Object pistons;
private DoubleSolenoid test;
private Compressor compressor;
 // Solenoid solidPCM;
  /** Creates a new Piston. */
  public Piston() {
  
    test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,4,6);
      

    // switch(up) {
    //   case E_ELEVATE: 
    //   test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,4,6);
    //   break;
    //   case E_CANNON:
    //   test = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,4,6);
    //   break;
    //   default: 
    //   System.out.println("DEFAULT GOT HIT");
    // }
  }
    // public enum pistons {
    //   E_ELEVATE,
    //   E_CANNON
      
    // }
 
    //Sets up the piston solidnoide needs to be given IDs once we connect the robot
    // solidPCM = new Solenoid(Id,PneumaticsModuleType.CTREPCM, Id);
    
  
  
   
   public void elevate() {
     if ( test.get() == Value.kForward) {
       test.set(Value.kReverse);
     } else if(test.get() == Value.kReverse) {
       test.set(Value.kForward);
       
       System.out.println(test.get());

     }
     
   }

   public void down() {
    // compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    //   compressor.enableDigital();
    //   compressor.getPressureSwitchValue();

   }
   

   public void off() {
    // test.set(Value.kOff);
     
   }

   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
