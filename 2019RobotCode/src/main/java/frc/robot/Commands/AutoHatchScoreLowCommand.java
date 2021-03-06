package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.RobotMap.ArmPreset;
import frc.robot.Subsystems.VisionSub.TargetType;

public class AutoHatchScoreLowCommand extends CommandGroup {
  public AutoHatchScoreLowCommand() {
    // Let the driver set the approach speed.
    this(0);

    // Hold the stop until this command is cancelled
    addSequential(new DriveStopCommand());
  }

  public AutoHatchScoreLowCommand(int approachSpeed) {
    setName("HATCH LOW");

    addSequential(new AutoArmCommand(ArmPreset.Low, -70));
    addSequential(new AutoSquareUpCommand(TargetType.HATCH, RobotMap.VISION_DISTANCE_TO_HATCH_LOW, approachSpeed));

    // Push forward and drop.
    addSequential(new AutoVelocityMoveCommand(300, 0, 1.00));
    addSequential(new AutoArmCommand(ArmPreset.Low, +400, true));
    addSequential(new AutoVelocityMoveCommand(-450, 0, 0.75));
  }
}
