/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

   private CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushed);
   private CANSparkMax leftMotor2 = new CANSparkMax(2, MotorType.kBrushed);
   private CANSparkMax rightMotor1 = new CANSparkMax(3, MotorType.kBrushed);
   private CANSparkMax rightMotor2 = new CANSparkMax(4, MotorType.kBrushed);

  private Joystick joy1 = new Joystick(0);

  private double startTime;

  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    System.out.println(time - startTime);

    if (time - startTime < 3) {
      leftMotor1.set(0.6);
      leftMotor2.set(0.6);
      rightMotor1.set(-0.6);
      rightMotor2.set(-0.6);
    } else {
      leftMotor1.set(0);
      leftMotor2.set(0);
      rightMotor1.set(0);
      rightMotor2.set(0);
    }
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1) * 0.6;
    double turn = joy1.getRawAxis(4) * 0.3;

    double left = speed + turn;
    double right = speed - turn;

    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(-right);
    rightMotor2.set(-right);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}