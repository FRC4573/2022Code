package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Drive {
  private WPI_VictorSPX m_frontRight = new WPI_VictorSPX(1);
  private WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(2);
  private WPI_VictorSPX m_rearRight = new WPI_VictorSPX(3);
  private WPI_VictorSPX m_rearLeft = new WPI_VictorSPX(4);
  
  private SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  private SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

  public Drive(){
      
  }
public SpeedControllerGroup getLeftSpeedController(){
    return this.m_left;
}
public SpeedControllerGroup getRightSpeedController(){
    return this.m_right;
}
}
