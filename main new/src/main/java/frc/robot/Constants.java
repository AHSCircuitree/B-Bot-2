// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.generated.TunerConstants;
import edu.wpi.first.math.geometry.Translation2d;
import static edu.wpi.first.units.Units.*;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class CAN_IDS {

    public static final int feedIntakeMotor = 36;
    public static final int KickUpMotorRight = 32;
    public static final int KickUpMotorLeft = 33;
    public static final int PivotMotor = 34;
    public static final int RightShooter = 30;
    public static final int LeftShooter = 31;

    public static final int PivotEncoder = 3;

  }

  public static class OperatorConstants {

    public static final int kDriverControllerPort = 0;


  }

  public static class Intake {

    public static final double INTAKE_SPEED = 1.0;
    public static final double DEPLOY_SLOT0_KP = 5.0;
    public static final double DEPLOY_SLOT1_KP = 1.5;
    public static final double DeploySpeed = 500000000000.0;
  }

  public static class KickUp {

     public static final double KickUpSpeed = 1.0;


  }

  public static class Shooter {

    public static final double ShootSpeed = 1.0;
    public static final double ShootSpeedClose = 55.0;
    public static final double ShootSpeedFar = 70.0;
  }

  public static class Drive {
   public static final double MAX_SPEED_MPS      = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond);
   /** Max angular rate (rad/s) — 0.75 rotations/sec, matches teleop drive default command. */
   public static final double MAX_ANGULAR_RATE_RPS = RotationsPerSecond.of(0.75).in(RadiansPerSecond);

   /** Fraction of max speed/rate applied as joystick deadband. */
   public static final double DEADBAND_PERCENT   = 0.14;

   // --- Speed scaling (used in drive default command) ---
   /** Current speed divisor (1.0 = full speed). Increase for a slower mode. */
   public static final double SPEED_DIVISOR      = 1.0;


  }

}
