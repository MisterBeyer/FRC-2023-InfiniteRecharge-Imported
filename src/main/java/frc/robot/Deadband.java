// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

/** Add your docs here. */
public class Deadband {
    
    public double deadBand(Double m_left, double deadBand) {
        System.out.println(m_left);
     if ( m_left > deadBand  ) {
     //System.out.println(" none negative deadband got called");
        return m_left;
     
     }
     if ( m_left < -deadBand) {
        System.out.println("negative deadband got called");
        return m_left;
     }
        return 0;

    }
}
