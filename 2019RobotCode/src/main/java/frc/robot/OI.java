/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Add your docs here.
 */
public class OI {
    public XboxController driver = new XboxController(0);
    public XboxController gunner = new XboxController(1);

    public double getTrn(){
        return driver.getX(Hand.kRight);
    }

    public double getSpd(){
        return driver.getY(Hand.kLeft);
    }
}
