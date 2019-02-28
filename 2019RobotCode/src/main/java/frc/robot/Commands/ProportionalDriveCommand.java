/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Other.Utility;
import frc.robot.shuffleboard.SettingsTab;

public class ProportionalDriveCommand extends Command {
  public ProportionalDriveCommand() {
    requires(Robot.DRIVE_SUB);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = Robot.OI.getProportionalSpeed();
    double turn = Robot.OI.getProportionalTurn();

    double leftSpeed = (speed + turn);
    double rightSpeed = (speed - turn);

    leftSpeed = Utility.clamp(leftSpeed, -1.0, 1.0);
    rightSpeed = Utility.clamp(rightSpeed, -1.0, 1.0);

    double trim = 0.0;

    if (speed > 0) {
      trim = SettingsTab.getFailsafeTrimForward();
    } else if (speed < 0) {
      trim = SettingsTab.getFailsafeTrimReverse();
    }

    if (trim > 0) {
      rightSpeed *= (1 - trim);
    } else if (trim < 0) {
      leftSpeed *= (1 + trim);
    }

    Robot.DRIVE_SUB.drive.tankDrive(leftSpeed, rightSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
