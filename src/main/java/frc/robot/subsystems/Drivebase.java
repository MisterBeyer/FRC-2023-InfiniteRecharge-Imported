package frc.robot.subsystems;

import java.util.Scanner;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class Drivebase extends SubsystemBase {
  Constants constant = new Constants();
    //Scanner scan = new Scanner(System.in);
    //System.out.println("HOW ARE YOU DOING TODAY");
    //int Answer = scan.nextInt();
    private final CANSparkMax front_Left = new CANSparkMax(1, MotorType.kBrushless);
    private final CANSparkMax back_Left = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax front_Right = new CANSparkMax(4, MotorType.kBrushless);
    private final CANSparkMax back_Right = new CANSparkMax(3, MotorType.kBrushless);

// TODO: create a speed limitor method that creates a speed limit verible that can be sent to example cammond
public double getEncoder() {
   return front_Left.getEncoder().getPosition() * constant.inchesPerRev;
  }
  public void setEncoder(){
    front_Left.getEncoder().setPosition(0);
    front_Right.getEncoder().setPosition(0);

  }    
  
  public void displayEncoder() {
    System.out.println(front_Left.getEncoder().getPosition());
  }
    public void tankDrive(double left_Input, double right_Input) {
        
       front_Left.set(left_Input );
        front_Right.set(right_Input );

        //front_Right.set(ControlMode.PercentOutput, right_Input);

    }
    // Example Command X Phill Swift Fanfic when
    // truely the best ship
    // Mecanical can't get on this level of fanfic
    public void auto() {
      // while (true){
      //   front_Left.set(-0.1);
      //   front_Right.set(-0.1);
      // }
      }
    }
