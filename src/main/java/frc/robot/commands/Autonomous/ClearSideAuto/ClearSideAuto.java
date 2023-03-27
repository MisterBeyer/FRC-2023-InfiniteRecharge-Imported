// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous.ClearSideAuto;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autonomous.AutoElevator;
import frc.robot.commands.Autonomous.AutoElevatorDown;
import frc.robot.commands.Autonomous.IntakeMotor;
import frc.robot.commands.Autonomous.OutTakeMotor;
import frc.robot.commands.Autonomous.TurnDeegree;
import frc.robot.commands.Autonomous.GetOverChargeStation.GetBackOnCharge;
import frc.robot.commands.Autonomous.GetOverChargeStation.GetOnChargeStation;
import frc.robot.commands.Autonomous.GetOverChargeStation.MoveOverCharfe;
import frc.robot.commands.Autonomous.MainChargeStation.Move10Feet;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ElevatorStart;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ClearSideAuto extends SequentialCommandGroup {

  private Move10Feet move10Feet;
  private IntakeMotor IntakeMotor;
  private OutTakeMotor OutTakeMotor;
  private Intake intake;
  private GetBackOnCharge on;
  private MoveOverCharfe off;
  private ElevatorStart m_elevator;
  private AutoElevator autoElevator;
  private final Drivebase m_subsystem;
  private AutoElevatorDown down;
  private GetOnChargeStation stay;
  private PowerDistribution powerDis;
  private TurnDeegree degree;
  private TurnDeegree degree2;

  private FirstForward firstMove;
  private Comeback Comback;

  public ClearSideAuto(Drivebase subsystem, ElevatorStart elevator, Intake intake, PowerDistribution powerDis
  ) {
    this.powerDis = powerDis;
    m_subsystem = subsystem;
    this.m_elevator =  elevator;
    this.intake = intake;
    //Intake intake, ElevatorStart elevator
    //  ElevatorPosition(Elevator, true, false, false, false, false, false)
    this.Comback = new Comeback(subsystem, intake);
    this.degree = new TurnDeegree(subsystem, 180);
    this.degree2 = new TurnDeegree(subsystem, 180);

    
    this.firstMove = new FirstForward(subsystem, intake, powerDis);
     this.move10Feet = new Move10Feet(subsystem);
     this.off = new MoveOverCharfe(subsystem);
     this.on = new GetBackOnCharge(subsystem);


    //this.Move5Feet = new Move5Feet(subsystem);
    this.autoElevator = new AutoElevator(elevator,intake);
    this.stay = new GetOnChargeStation(subsystem);
    this.OutTakeMotor = new OutTakeMotor(intake);
    // this.NoPidTurn90 = new NoPidTurn90(subsystem);
     this.IntakeMotor = new IntakeMotor(intake);
     this.down = new AutoElevatorDown(elevator, intake);
    // this.OutTakeMotor = new OutTakeMotor(intake);


    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
   //addCommands(autoElevator);
    //addCommands(OutTakeMotor);
    //addCommands(move10Feet);
    //addCommands(Move5Feet);
      addCommands(degree);
      addCommands(firstMove);
      addCommands(degree2);

      addCommands(Comback);
      // addCommands(autoElevator);
      //  addCommands(IntakeMotor);
      //  addCommands(down);
      // // addCommands(move10Feet);
      // addCommands(off);
      // addCommands(on);
      // addCommands(stay);



    // addCommands(OutTakeMotor);

  }
}
