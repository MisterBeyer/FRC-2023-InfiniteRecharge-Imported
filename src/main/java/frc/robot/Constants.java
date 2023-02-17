// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public int front_Left = 1;
    public int back_Left = 3;
    public int front_right = 4;
    public int back_Right = 2;
    public int elevatorLeftMotor = 5;
    public int elevatorRightMotor = 6;

    public int pigeon = 999999;
    public int intakeMotor = 99999;
    public double deadband = .15;
    public double mediumSpeed = .50;
    public double slowSpeed = .15;
    public double ElevatorP = 0.0004;
    
    public double inchesPerRev = 2.58;
}
