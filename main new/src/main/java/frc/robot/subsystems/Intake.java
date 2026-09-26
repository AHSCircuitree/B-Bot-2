// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Intake extends SubsystemBase {

  private final TalonFX feedMotor;
  private final TalonFX PivotMotor;
  private final CANcoder PivotEncoder;

  /** Creates a new Intake. */

 private final VoltageOut m_voltageOut = new VoltageOut(0);

 
 private final StatusSignal<edu.wpi.first.units.measure.Angle> m_PivotPosition;

  public Intake() {

    feedMotor   = new TalonFX(Constants.CAN_IDS.feedIntakeMotor, "B-bot");
    PivotMotor = new TalonFX(Constants.CAN_IDS.PivotMotor, "B-bot");
    PivotEncoder = new CANcoder(Constants.CAN_IDS.PivotEncoder, "B-bot");

    Slot0Configs slot0ConfigsUp = new Slot0Configs();
    slot0ConfigsUp.kP = Constants.Intake.DEPLOY_SLOT0_KP;
    slot0ConfigsUp.kI = 0.0;
    slot0ConfigsUp.kD = 0.0;

    Slot1Configs slot1ConfigsDown = new Slot1Configs();
    slot1ConfigsDown.kP = Constants.Intake.DEPLOY_SLOT1_KP;
    slot1ConfigsDown.kI = 0.0;
    slot1ConfigsDown.kD = 0.0;

    m_PivotPosition = PivotMotor.getPosition();


  }

public void intake() {
    feedMotor.set(Constants.Intake.INTAKE_SPEED);
  }

public void outtake() {
    feedMotor.set(-Constants.Intake.INTAKE_SPEED);
  }

public void stopWheels() {
    feedMotor.setControl(m_voltageOut.withOutput(0));
  
  }
  
   public void deployManual(double speed) {
    PivotMotor.set(speed);
  }

  public void stopDeploy() {
    PivotMotor.set(0);
  }

  public void deployBrake() {
    MotorOutputConfigs motorOutput = new MotorOutputConfigs();
    motorOutput.NeutralMode = NeutralModeValue.Brake;
    PivotMotor.getConfigurator().apply(motorOutput, 0.0);
  }

  public double getPivotEncoder() {
    return m_PivotPosition.getValueAsDouble() + 1;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
