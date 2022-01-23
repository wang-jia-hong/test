// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public WPI_VictorSPX leftfrontmotor=new WPI_VictorSPX(4);
  public WPI_VictorSPX leftrearmotor=new WPI_VictorSPX(2);
  public WPI_VictorSPX rightfrontmotor=new WPI_VictorSPX(1);
  public WPI_VictorSPX rightrearmotor=new WPI_VictorSPX(3);

  @Override
  public void robotInit() {
    leftfrontmotor.setInverted(false);
    rightfrontmotor.setInverted(false);

    leftrearmotor.follow(leftfrontmotor);
    rightrearmotor.follow(leftfrontmotor);

    leftrearmotor.setInverted(InvertType.FollowMaster);
    rightrearmotor.setInverted(InvertType.FollowMaster);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    if (time<5){
      leftfrontmotor.set(0.7);
      rightfrontmotor.set(-0.7);
    }
    else{
      leftfrontmotor.set(0);
      rightfrontmotor.set(0);
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
