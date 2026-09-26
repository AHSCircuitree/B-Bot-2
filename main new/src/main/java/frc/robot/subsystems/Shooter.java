// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final TalonFX RightShooter;
  private final TalonFX LeftShooter;

  private final VelocityVoltage m_velocityRequest = new VelocityVoltage(0).withFeedForward(0).withSlot(0);



  private double targetVelocity = 0;

    private final StatusSignal<edu.wpi.first.units.measure.AngularVelocity> m_LeftShooterVelocity;
    private final StatusSignal<edu.wpi.first.units.measure.AngularVelocity> m_RightShooterVelocity;


  /** Creates a new Shooter. */
  public Shooter() {

    RightShooter = new TalonFX(Constants.CAN_IDS.RightShooter, "B-bot");
    LeftShooter = new TalonFX(Constants.CAN_IDS.LeftShooter, "B-bot");

    m_LeftShooterVelocity  = LeftShooter.getVelocity();
    m_RightShooterVelocity = RightShooter.getVelocity();

  }

  public void spin(double speed) {
    targetVelocity = speed;
    LeftShooter.setControl(m_velocityRequest.withVelocity(targetVelocity));
    RightShooter.setControl(m_velocityRequest.withVelocity(targetVelocity));

  }

  public void stopShooter() {
    LeftShooter.set(0);
    RightShooter.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
