// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.subsystems.Drivebase;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.function.DoubleSupplier;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;
import edu.wpi.first.math.*;
import com.ctre.phoenix.motorcontrol.ControlMode;


// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.Spark;
import frc.robot.Deadband;
import edu.wpi.first.wpilibj.Compressor;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  private final Drivebase drivebase;
  // private final Spark front_Left = new Spark(4);
  // private final Spark back_Left = new Spark(1);
  // private final Spark front_Right = new Spark(11);
  // private final Spark back_Right = new Spark(7);
  private final XboxController gamePad;
  private Drivebase subsystem;
  
  // private DoubleSupplier right;
  // private DoubleSupplier left;
  private MotorControllerGroup left;
  private MotorControllerGroup right;
  private Deadband dead;



 // private final Compressor compressor;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings


  //  m_subsystem = subsystem;
  //  m_left = left;
  //  m_right = right;
    // final Spark front_Left = new Spark(3);
    // final Spark back_Left = new Spark(1);
    // final Spark front_Right = new Spark(11);
    // final Spark back_Right = new Spark(7);
    
    // MotorControllerGroup left = new MotorControllerGroup(front_Right, back_Right);
    // MotorControllerGroup right = new MotorControllerGroup(front_Left, back_Left);


    //auto = new ExampleCommand(m_subsystem, m_left, m_right);

    drivebase = new Drivebase();
    dead = new Deadband();
    gamePad = new XboxController(0);
    
    configureButtonBindings();
    // Might have to chang raw axis 5 to 4 since 5 is forward and backward but 4 is left and right 
    
    // double Joystickx = gamePad.getRawAxis(1);
    // double Joysticky = gamePad.getRawAxis(5);
    // System.out.println("Joystickx is " + Joystickx);
    // System.out.println("Joysticky is " + Joysticky);

    
    
    // else if (  Joysticky <= .15 ){ 
    // }
          //  drivebase.setDefaultCommand(new ExampleCommand(drivebase, () -> dead.deadBand(Joystickx, .15), () -> dead.deadBand(Joysticky, .15)));
          drivebase.setDefaultCommand(new ExampleCommand(drivebase, () -> gamePad.getRawAxis(1), () -> gamePad.getRawAxis(5)));

    // Set up compressor
      // compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
      // compressor.enableDigital();

    
  }

  /*
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
// this activates the shoot command also might've gotte nthe button port wrong 
    
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // left.set(5);
    // right.set(5);
    
    // TO DO put robot moving on a timer
/*        I hate everyone on the robotics team
 * 
 */

    //drivebase.tankDrive(5, 5);
    //drivebase.tankDrive(5, 5);
    // An ExampleCommand will run in autonomous
    return new CommandBase() {

    };
  }
}
