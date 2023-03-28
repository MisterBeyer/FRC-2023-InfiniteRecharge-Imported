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
    // Motors
   // channel 0 left rear drive
   // channel 1 left elevator
   //channel 2 right elevator
   // channel 3 right rear drive
   // channel 11 vrm
   // channel 12 right frot drive
   // channel 14 intake
   // channel 15 left front drive
    


    public int front_Left = 1;
    public int back_Left = 3;
    public int front_right = 4;
    public int back_Right = 2;
    public int elevatorLeftMotor = 5;
    public int elevatorRightMotor = 6;
    public int intakeMotor = 99999;
    public int pigeon = 999999;

    //modfiers
    public double deadband = .15;
    public double mediumSpeed = .50;
    public double slowSpeed = .15;
    //elevator top 2.75
    //elevator top 60.5 links/ 16 inches
    //22 teeths
    // Elevator
    public double topPosition = 14;
    //14
    public double medPosition = 13;
    //13 as main
    public double lowPos = .5;
    public double zero = 0;
    public double ElevatorP = .9;
    public double ElevatorI = 0.00001;
    public double ElevatorD = 0.0;
    // orginal .0025
    //
    public double TurnP = 0.009;
    public double TurnI = 0.0;
    public double TurnD = 0.0;
    public double elevatorErrorThresh = 3; // set point thresh hold 
    public double elevatorMinSpeed = .1;
    public double elevatorMaxSpeed = .5;
    public double maxSetPoint = 17.0;
    public double minSetPoint = 0;

    public double ampActivation = 30;
    public double ampTimer = .5;
    public double autoStowSetPoint = .5;

//004 P
// 000004 I
    public double chargeP = 0.003;
    public double chargeI = 0.00004;

    public double degree = 180;
    public double turnThres = 1;
    //math
    public double neoTicksPerRev = 999999999999.9;
    public double gearRatio = .11;
    public double inchesPerRev = 2.58;
}
