// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ElevatorStart;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GetOver extends SequentialCommandGroup {

  private Move10Feet move10Feet;
  private IntakeMotor IntakeMotor;
  private OutTakeMotor OutTakeMotor;
  private Intake intake;
  private GetBackOnCharge on;
  private MoveOverCharfe off;
  private ElevatorStart m_elevator;
  private AutoElevator autoElevator;
  private final Drivebase m_subsystem;
  private Move5Feet Move5Feet;
  private AutoElevatorDown down;


  public GetOver(Drivebase subsystem, ElevatorStart elevator, Intake intake
  ) {
    
    m_subsystem = subsystem;
    this.m_elevator =  elevator;
    this.intake = intake;
    //Intake intake, ElevatorStart elevator
    //  ElevatorPosition(Elevator, true, false, false, false, false, false)
     this.move10Feet = new Move10Feet(subsystem);
     this.off = new MoveOverCharfe(subsystem);
     this.on = new GetBackOnCharge(subsystem);


    //this.Move5Feet = new Move5Feet(subsystem);
    this.autoElevator = new AutoElevator(elevator,intake);
    //this.OutTakeMotor = new OutTakeMotor(intake);
    // this.NoPidTurn90 = new NoPidTurn90(subsystem);
     this.IntakeMotor = new IntakeMotor(intake);
     this.down = new AutoElevatorDown(elevator, intake);
    // this.OutTakeMotor = new OutTakeMotor(intake);


    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
   addCommands(autoElevator);
    //addCommands(OutTakeMotor);
    //addCommands(move10Feet);
    //addCommands(Move5Feet);
      // addCommands(autoElevator);
       addCommands(IntakeMotor);
       addCommands(down);
      // addCommands(move10Feet);
      addCommands(off);
      addCommands(on);


    // addCommands(OutTakeMotor);

  }
}
