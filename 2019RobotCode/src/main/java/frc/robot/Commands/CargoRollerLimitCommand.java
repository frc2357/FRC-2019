/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.overlays.CargoControl;

public class CargoRollerLimitCommand extends Command {
  private CargoControl controller;
  private boolean reset;

  public CargoRollerLimitCommand(CargoControl controller) {
    requires(Robot.CARGO_SUB);
    this.controller = controller;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    this.reset = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = controller.getCargoRollerSpeed();

    if (Robot.CARGO_SUB.isLimit()) {
      if (speed == 0.0) {
        reset = true;
      }

      if (!reset) {
        speed = 0.0;
      }
    } else {
      reset = false;
    }

    Robot.CARGO_SUB.cargoRollerDirect(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.CARGO_SUB.cargoRollerStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
