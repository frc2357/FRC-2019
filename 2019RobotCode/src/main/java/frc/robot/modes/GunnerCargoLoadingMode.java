package frc.robot.modes;

import frc.robot.Robot;
import frc.robot.overlays.GunnerCargoFromFloor;

public class GunnerCargoLoadingMode extends ModeBase {

  @Override
  public void activate() {
    Robot.OI.setGunnerOverlay(new GunnerCargoFromFloor(Robot.OI.getGunnerController()));
  }

  @Override
  public void deactivate() {

  }

}