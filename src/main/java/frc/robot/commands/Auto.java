// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto extends SequentialCommandGroup {

  private Move10Feet move10Feet;
  private IntakeMotor IntakeMotor;
  private OutTakeMotor OutTakeMotor;

  
  private final Drivebase m_subsystem;
  private Intake Intake;


  public Auto(Drivebase subsystem,
              Intake intake
  ) {
    m_subsystem = subsystem;
    this.Intake = new Intake();
    this.move10Feet = new Move10Feet(subsystem);
    // this.NoPidTurn90 = new NoPidTurn90(subsystem);
    // this.IntakeMotor = new IntakeMotor(intake);
    // this.OutTakeMotor = new OutTakeMotor(intake);


    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(move10Feet);
    // addCommands(IntakeMotor);
    // addCommands(OutTakeMotor);

  }
}
