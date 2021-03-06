/*----------------------------------------------------------------------------*/
/* Copyright (c) 2021 - 2022 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Spark;


 //**************************************************************************\\
 // The VM is configured to automatically run this class, and to call the    \\
 // functions corresponding to each mode, as described in the TimedRobot     \\
 // documentation. If you change the name of this class or the package after \\
 // creating this project, you must also update the build.gradle file in the \\
 // project.                                                                 \\
 //**************************************************************************\\
public class Robot extends TimedRobot {
  Joystick drive_stick;
  Joystick control_stick;
  DifferentialDrive m_drive;

  double m_deadZone;
  double m_driveMotorSpeed;
  double m_driveTurnSpeed;
  double displayCtr;
  static final int IMG_WIDTH = 320;
  static final int IMG_HEIGHT = 240;

//////////////////////////BUTTON MAPPINGs\\\\\\\\\\\\\\\\\\\\\\\\\
  
 // Control Stick \\
 /*  sample for button mappings
  static final int BTNSHOOTERBACK = 11;  // Reverse Shooter
    */                    
  // Drive Stick \\
  //////////////////////////BUTTON MAPPINGs\\\\\\\\\\\\\\\\\\\\\\\\\
  static boolean commandRan = false;

    //////////////////////////Motor Controllers\\\\\\\\\\\\\\\\\\\\\\\\\
  WPI_VictorSPX m_frontRight = new WPI_VictorSPX(1);
  WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(2);
  WPI_VictorSPX m_rearRight = new WPI_VictorSPX(3);
  WPI_VictorSPX m_rearLeft = new WPI_VictorSPX(4);
  
  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  
    //////////////////////////Motor Controllers\\\\\\\\\\\\\\\\\\\\\\\\\

  Timer timer = new Timer();

  
  
  //****************************************************************************\\
  // This function is run when the robot is first started up and should be used \\
  // for any initialization code.                                               \\
  //****************************************************************************\\
  
  
  @Override
  public void robotInit() {

    System.out.println("Robot Init: ");

    m_deadZone = 0.3;
    m_driveMotorSpeed = 1;
    m_driveTurnSpeed = 0.75;
    displayCtr = 0;
    //////////////////////////Speed Settings\\\\\\\\\\\\\\\\\\\\\\\\\



    //////////////////////////Speed Settings\\\\\\\\\\\\\\\\\\\\\\\\\
    
    
  drive_stick = new Joystick(0);
  control_stick = new Joystick(1);


    m_drive = new DifferentialDrive(m_left, m_right);
    m_drive.setExpiration(0.50);
    m_drive.arcadeDrive(0, 0, true);
    m_drive.setSafetyEnabled(false);
   
  }

  //*********************************************************************************\\
  // This function is called every robot packet, no matter the mode. Use this for    \\
  // items like diagnostics that you want ran during disabled, autonomous,           \\
  // teleoperated and test.                                                          \\
  //                                                                                 \\                                                                            \\
  // This runs after the mode specific periodic functions, but before LiveWindow     \\
  // and SmartDashboard integrated updating.                                         \\
  //*********************************************************************************\\
  

  @Override
  public void autonomousInit() {
    System.out.println("StartAutoInit");
    timer.start();
    System.out.println("EndAutoInit");
  }

 
  @Override
  public void autonomousPeriodic() {
  
  //code for autonomous period, timer and while recommended \\

    }

  //********************************************************\\
  // This function is called at the start of Teloeop.       \\
  //********************************************************\\
  @Override
  public void teleopInit() {
    m_drive.arcadeDrive(0.0,0.0);
  }

  //*******************************************************************\\
  // This function is called periodically during operator control.     \\
  //*******************************************************************\\
  @Override
  public void teleopPeriodic() {

    // Get Drive Joystick input for arcade driving

    double X = getJoystickValue(drive_stick, 1) * m_driveMotorSpeed;
    double Z = getJoystickValue(drive_stick, 2) * m_driveTurnSpeed;
    
    m_drive.arcadeDrive(-X, Z, true); // Drive the robot
   
  }

  @Override
  public void robotPeriodic() {
    
  }
  

  @Override
  public void testPeriodic() {
    
  }

  //*******************************************************************\\
  //This function is used to read joystick & eliminate deadzone issues \\
  //*******************************************************************\\

  public double getJoystickValue(Joystick joystick, int iKey) {
    double dVal = joystick.getRawAxis(iKey);
    if (Math.abs(dVal) < m_deadZone) {
      return 0;
    } else {
      return dVal;
    }
  }
}
  
  

//Insert Funcitons below
    
  
 