package frc.robot.shuffleboard;

public class ShuffleboardController {
  private SettingsTab settingsTab = new SettingsTab();
  private TestTab testTab = new TestTab();

  public void test() {
    testTab.show();
  }

  public void settings() {
    settingsTab.show();
  }

  public void periodic() {
    testTab.periodic();
  }
}
