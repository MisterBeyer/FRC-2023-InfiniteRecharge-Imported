// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
public class Intake extends SubsystemBase {
  private Solenoid solenoide;

  /** Creates a new Intake. */
  public Intake() {
  this.solenoide = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  }
  public void upAndDown() {

    solenoide.toggle();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
