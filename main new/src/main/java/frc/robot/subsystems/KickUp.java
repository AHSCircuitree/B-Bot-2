// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class KickUp extends SubsystemBase {
  
  public final TalonFX KickUpMotorRight;
  public final TalonFX KickUpMotorLeft;
   
  /** Creates a new KickUp. */
  public KickUp() {
    KickUpMotorLeft = new TalonFX(Constants.CAN_IDS.KickUpMotorLeft, "B-bot");
    KickUpMotorRight = new TalonFX(Constants.CAN_IDS.KickUpMotorRight, "B-bot");
  }

  public void shoot(){
    KickUpMotorLeft.set(Constants.KickUp.KickUpSpeed);
    KickUpMotorRight.set(Constants.KickUp.KickUpSpeed);
  }

  public void stop(){
    KickUpMotorLeft.set(0);
    KickUpMotorRight.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
