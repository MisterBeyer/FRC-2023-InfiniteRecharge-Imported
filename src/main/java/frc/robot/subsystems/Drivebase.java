package frc.robot.subsystems;

import java.util.Scanner;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
public class Drivebase extends SubsystemBase {
  Constants constant = new Constants();
    //Scanner scan = new Scanner(System.in);
    //System.out.println("HOW ARE YOU DOING TODAY");
    //int Answer = scan.nextInt();

    private final CANSparkMax front_Left = new CANSparkMax(constant.front_Left,MotorType.kBrushless);
    private final CANSparkMax back_Left = new CANSparkMax(constant.back_Left, MotorType.kBrushless);
    private final CANSparkMax front_Right = new CANSparkMax(constant.front_right, MotorType.kBrushless);
    private final CANSparkMax back_Right = new CANSparkMax(constant.back_Right, MotorType.kBrushless);
   // private final PigeonIMU gyro = new PigeonIMU(10);
   //private PigeonIMU.FusionStatus fusionStatus = new PigeonIMU.FusionStatus();
   private double  rampleft = 0;
   private double  rampright = 0;



  public Drivebase() {
   // back_Left.setInverted(true);
front_Right.setInverted(true);
back_Right.setInverted(true);
  
  setEncoder();
  front_Left.setIdleMode(IdleMode.kCoast);
  front_Right.setIdleMode(IdleMode.kCoast);
  back_Left.setIdleMode(IdleMode.kCoast);
  back_Right.setIdleMode(IdleMode.kCoast);


  front_Left.getEncoder().setPositionConversionFactor(2.58);
  front_Right.getEncoder().setPositionConversionFactor(2.58);

  }

  public double leftGetSpeed() {
    return front_Left.get();
  }
  public double RightGetSpeed() {
    return front_Right.get();
  }


   public void setGyro(){
 // gyro.setFusedHeading(0);
}
// public double getGyro(){
//   return gyro.getFusedHeading(fusionStatus);
// }
// public void displayGyro(){
//    System.out.println(gyro.getFusedHeading(fusionStatus));
// }
public double getEncoder() {
   return front_Left.getEncoder().getPosition() * constant.inchesPerRev;
   
  }
  public void setEncoder(){
    front_Left.getEncoder().setPosition(0);
    front_Right.getEncoder().setPosition(0);

  }   
  
  public void setIdleMode(){
    front_Left.setIdleMode(IdleMode.kBrake);
    front_Right.setIdleMode(IdleMode.kBrake);
    back_Left.setIdleMode(IdleMode.kBrake);
    back_Right.setIdleMode(IdleMode.kBrake);

  }
  
  public void displayEncoder() {
    System.out.print(front_Left.getEncoder().getVelocity());
    System.out.print(" ");
    System.out.println(front_Right.getEncoder().getVelocity());

  }
    public void tankDrive(double right_Input, double left_Input) {
          

        front_Left.set(left_Input );
         front_Right.set(right_Input );
        back_Left.set(left_Input);
        back_Right.set(right_Input);
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
