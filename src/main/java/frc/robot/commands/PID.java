// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PID extends PIDCommand {
  /** Creates a new PID. */
  private final CANSparkMax elevator = new CANSparkMax(8, MotorType.kBrushless);
   private RelativeEncoder encoder;
  //TODO move p.i.d to constants 
  public PID() {

    super(
        // The controller that the command will use
        new PIDController(0.0004, 0.00001, 0.0008),
        // This should return the measurement
        () -> encoder.getPosition();,
        // This should return the setpoint (can also be a constant)
        () -> 2000,
        // This uses the output
        output -> {
        elevator.set(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
