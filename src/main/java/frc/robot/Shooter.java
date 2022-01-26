package frc.robot;

import edu.wpi.first.wpilibj.Talon;

//Niko was here

public class Shooter {
    private Talon motor1 = new Talon(0);
    private Talon motor2 = new Talon(1);
    private Talon motor3 = new Talon(2);

    //Forward Functions
    public Talon getMotor1(){
        return this.motor1;
    }
    public Talon getMotor2(){
        return this.motor2;
    }
    public Talon getMotor3(){
        return this.motor3;
    }
    public void setMotor1Forward(){
        this.motor1.setSpeed(1.0);
    }
    public void setMotor2Forward(){
        this.motor2.setSpeed(0.8);
    }
    public void setMotor3Forward(){
        this.motor3.setSpeed(0.8);
    }

    //Reverse Functions
    public void setMotorReverse1(){
        this.motor1.setSpeed(-1);
    }
    public void setMotorReverse2(){
        this.motor2.setSpeed(-1);
    }   
    public void setMotorReverse3(){
        this.motor3.setSpeed(-0.5);
    }

    //Stopping Functions
    public void setMotorStop1(){
        this.motor1.setSpeed(0.0);
    }
    public void setMotorStop2(){
        this.motor2.setSpeed(0.0);
    }
    public void setMotorStop3(){
        this.motor3.setSpeed(0.0);
    }
}