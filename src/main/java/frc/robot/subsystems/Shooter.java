// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final TalonFX ShooterRight; //shooterRight
  private final TalonFX ShooterLeft; //shooterLeft

  private final VelocityVoltage m_velocityRequest = new VelocityVoltage(0).withFeedForward(0).withSlot(0);



  private double targetVelocity = 0;

    private final StatusSignal<edu.wpi.first.units.measure.AngularVelocity> m_ShooterLeftVelocity;
    private final StatusSignal<edu.wpi.first.units.measure.AngularVelocity> m_ShooterRightVelocity;


  /** Creates a new Shooter. */
  public Shooter() {

    ShooterRight = new TalonFX(Constants.CAN_IDS.ShooterRight, "B-bot");
    ShooterLeft = new TalonFX(Constants.CAN_IDS.ShooterLeft, "B-bot");

    m_ShooterLeftVelocity  = ShooterLeft.getVelocity();
    m_ShooterRightVelocity = ShooterRight.getVelocity();

  }

  public boolean isAtSpeed() {
    
    SmartDashboard.putNumber("voltage", ShooterLeft.getMotorVoltage().getValueAsDouble());
    return ShooterLeft.getMotorVoltage().getValueAsDouble() >= 6;
    
  }

  public void spin(double speed) {
    targetVelocity = speed;
    //ShooterLeft.setControl(m_velocityRequest.withVelocity(targetVelocity));
    ShooterRight.setControl(m_velocityRequest.withVelocity(targetVelocity));
    ShooterLeft.setControl(m_velocityRequest.withVelocity(targetVelocity));
  }

  public void justRun(double speed) {
    ShooterRight.set(speed);
    ShooterLeft.set(speed);
  }



  public void stopShooter() {
    //ShooterLeft.set(0);
    ShooterRight.set(0);
    ShooterLeft.set(targetVelocity);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
