// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Arcade_Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
/** Add your docs here. */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
TalonFX right_Motor = new TalonFX(RobotMap.rightMotor);
TalonFX right_Slave = new TalonFX(RobotMap.rightSotor);
TalonFX left_Motor = new TalonFX(RobotMap.leftMotor);
TalonFX left_Slave = new TalonFX(RobotMap.leftSotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Arcade_Drive());
  }
  public void setRightMotor(double s) {
    right_Motor.set(ControlMode.PercentOutput, -s);
    right_Slave.follow(right_Motor);
  }
  public void setLeftMotor(double s) {
    left_Motor.set(ControlMode.PercentOutput, s);
    left_Slave.follow(left_Motor);;
  }
}
