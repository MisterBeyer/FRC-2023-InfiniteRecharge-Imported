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


public class Cannon extends SubsystemBase {
   Solenoid air;
  // DoubleSolenoid test;
  // DoubleSolenoid solidPCM;
  /** Creates a new Double_solid. */
   public Cannon() {
    // solidPCM = new Solenoid(PneumaticsModuleType.CTREPCM,1);
    //solidPCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,3,7);
      air = new Solenoid(PneumaticsModuleType.CTREPCM,7);
    // I.D NUMBERS ARE NOT OFFICAL AND WILL NEED TO BE RE WRITTEN LATER WHEN THE BOSS IS READY single 
   }

   public void toggleShoot()
   {
     System.out.println("current channel of the code is  " +  air.get() );
     air.toggle();
     System.out.println(" ITT WAS ACTUAL CANNON ");
    //  solidPCM.set(Value.kForward);
     
   }
     

   
   

   
   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
