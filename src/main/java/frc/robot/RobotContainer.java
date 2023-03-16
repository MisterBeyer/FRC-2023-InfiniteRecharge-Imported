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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ElevatorStart;
import frc.robot.subsystems.Intake;
//import frc.robot.commands.Auto;
import frc.robot.commands.ElevatorPosition;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeMovements;
import frc.robot.commands.IntakePnumatic;
import frc.robot.commands.ElevatorPosition;
import frc.robot.commands.Autonomous.AutoElevator;
import frc.robot.commands.Autonomous.IntakeMotor;
import frc.robot.commands.Autonomous.Turn90;
import frc.robot.commands.Autonomous.GetOverChargeStation.GetOver;
import frc.robot.commands.Autonomous.MainChargeStation.Auto;
import frc.robot.commands.Autonomous.MainChargeStation.Move10Feet;
// import frc.robot.commands.moveSoleioid;
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
  private  XboxController drive = new XboxController(1);

  private Drivebase drivebase = new Drivebase();
 //private Compressor compressor;
  // private DoubleSupplier right;
  // private DoubleSupplier left;
  private MotorControllerGroup left;
  private MotorControllerGroup right;
  private Deadband dead;
  private ExampleCommand example;
  private Constants constant;
  private ElevatorStart elevator = new ElevatorStart();
  private ElevatorPosition elevatorPosition;
  // private soleioid solenoid;
  //private soleioid solenoid;
  private IntakeMotor IntakeMotor;
  private IntakePnumatic pnumatic; 
 // private  SendableChooser<Command> autoChooser = new SendableChooser<>();
 // private Auto autonomous;
  private Move10Feet move10Feet;
  Joystick j = new Joystick(0);
  private Intake intake = new Intake();
  // private moveSoleioid soleioid = new moveSoleioid();
  private Auto auto = new Auto(drivebase,elevator,intake);
  private GetOver fancyAuto = new GetOver(drivebase,elevator,intake);




  private final Compressor compressor;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
   public RobotContainer() {
//  autoChooser.setDefaultOption(" Charge Station", auto);
//  autoChooser.addOption(" test", IntakeMotor);
//  SmartDashboard.putData(autoChooser);

     compressor = new Compressor(PneumaticsModuleType.CTREPCM);
   // compressor = new Compressor(10, PneumaticsModuleType.CTREPCM);
    drivebase.setEncoder();
      drivebase.setDefaultCommand(
        new ExampleCommand(
          drivebase, 
          () -> drive.getRawAxis(1),
          () -> drive.getRawAxis(4), 
          () -> drive.getLeftBumper(),  
          () -> drive.getRightBumper()));
    configureButtonBindings();

    elevator.setDefaultCommand(
        new ElevatorPosition(
          elevator, 
          () -> gamePad.getRawButton(4),
          () -> gamePad.getRawButton(2),
          () -> gamePad.getRawButton(1),
          () -> gamePad.getRightBumper(),
          () -> gamePad.getLeftBumper(),
          () -> gamePad.getStartButton()


       ));
    //   elevator.setDefaultCommand(
    //     new ElevatorManual(
    //       elevator, 
    //       () -> gamePad.getLeftBumper(),
    //       () -> gamePad.getRightBumper()

    //  ));
      intake.setDefaultCommand(
        new IntakeMovements(
          intake, 
          () -> gamePad.getRawButton(9), // on
          () -> gamePad.getRawButton(10),// in
          () -> gamePad.getRawButtonReleased(3) //out

       ));
    //configureButtonBindings();
  }
  

   private void configureButtonBindings() {
   //new JoystickButton(gamePad, 1).whileTrue(IntakeMotor);

   
    //new JoystickButton(gamePad, 1).onTrue( new ElevatorMediumPosition());
    // new JoystickButton(gamePad, 1).onTrue( new IntakePnumatic());
  //   new JoystickButton(gamePad, 3).onTrue( new ElevatorBottomPosition());
   // new JoystickButton(gamePad, 4).onTrue( new ElevatorTopPosition());
     //new JoystickButton(gamePad, 2).onTrue( new OutakeMotor());
   // new JoystickButton(gamePad, 3).whileTrue( new IntakeMotor(intake));
  //  new JoystickButton(gamePad, 4).whileTrue( new moveSoleioid());
  //new JoystickButton(gamePad, 2).onTrue(ElevatorBottomPosition);

  CameraServer.startAutomaticCapture();

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new  GetOver(drivebase, elevator, intake);
    //Auto(drivebase,elevator,intake);

    //Auto(drivebase,elevator);

    // TO DO put robot moving on a timer
/*        I hate everyone on the robotics team
 */
// example.execute();

    //drivebase.tankDrive(5, 5);
    //drivebase.tankDrive(5, 5);
    // An ExampleCommand will run in autonomous
    
  }
}
