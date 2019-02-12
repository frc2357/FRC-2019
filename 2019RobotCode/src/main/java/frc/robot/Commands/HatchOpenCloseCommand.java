/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.HatchSub;

public class HatchOpenCloseCommand extends Command {

  boolean open, close;

  /**
   * 
   * @param open If the button to open the hatch gantries is held
   * @param close If the button to close the hatch gantries is held
   */
  public HatchOpenCloseCommand(boolean open, boolean close) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.HATCH_SUB);

    this.open = open;
    this.close = close;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if((open && close) || (!open && !close)) {
      Robot.HATCH_SUB.failsafeMoveGantry(HatchSub.direction.stop);
    } else if(open) {
      Robot.HATCH_SUB.failsafeMoveGantry(HatchSub.direction.open);
    } else if(close) {
      Robot.HATCH_SUB.failsafeMoveGantry(HatchSub.direction.close);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
