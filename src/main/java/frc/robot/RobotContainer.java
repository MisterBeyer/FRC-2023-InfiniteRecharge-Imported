// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Intake;
import frc.robot.commands.ElevatorBottomPosition;
import frc.robot.commands.ElevatorMediumPosition;
import frc.robot.commands.ElevatorTopPosition;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeMotor;
import frc.robot.commands.IntakePnumatic;
import frc.robot.commands.Move10Feet;
import frc.robot.commands.OutakeMotor;
import frc.robot.commands.SolenoidStart;
import frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import java.util.function.DoubleSupplier;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import edu.wpi.first.cameraserver.CameraServer;
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
  private Joystick joystick;
  
  private  XboxController gamePad = new XboxController(0);
  private Drivebase drivebase = new Drivebase();
 private Compressor compressor;
  // private DoubleSupplier right;
  // private DoubleSupplier left;
  private MotorControllerGroup left;
  private MotorControllerGroup right;
  private Deadband dead;
  private ExampleCommand example;
  private Constants constant;
  private IntakeMotor IntakeMotor;
  private SolenoidStart Solenoid;
  private auto autonomous;
  private Move10Feet move10Feet;
  Joystick j = new Joystick(0);


  private ElevatorBottomPosition ElevatorBottomPosition; 


  //private final Compressor compressor;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    drivebase.setEncoder();
    drivebase.setDefaultCommand(
        new ExampleCommand(
          drivebase, 
          () -> gamePad.getRawAxis(1),
          () -> gamePad.getRawAxis(5), 
          () -> gamePad.getLeftBumper(),  
          () -> gamePad.getRightBumper()));
    configureButtonBindings();
  }

   private void configureButtonBindings() {
  // new JoystickButton(gamePad, 1).whileTrue(IntakeMotor);

   
    new JoystickButton(gamePad, 1).onTrue( new ElevatorMediumPosition());
  //   new JoystickButton(gamePad, 2).onTrue( new IntakePnumatic());
  //   new JoystickButton(gamePad, 3).onTrue( new ElevatorBottomPosition());
  //   new JoystickButton(gamePad, 9).onTrue( new ElevatorTopPosition());
  //   new JoystickButton(gamePad, 5).onTrue( new OutakeMotor());
  //   new JoystickButton(gamePad, 6).onTrue( new IntakeMotor());

  //new JoystickButton(gamePad, 2).onTrue(ElevatorBottomPosition);
   
  CameraServer.startAutomaticCapture();

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new auto(drivebase);

    // TO DO put robot moving on a timer
/*        I hate everyone on the robotics team
 */
// example.execute();

    //drivebase.tankDrive(5, 5);
    //drivebase.tankDrive(5, 5);
    // An ExampleCommand will run in autonomous
    
  }
}
