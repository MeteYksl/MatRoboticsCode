// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DigitalInput;
public class Robot extends TimedRobot {
  

    public static int bluekontrol=0;
    public static int yellowkontrol=0;
    public static int greenkontrol=0;
    public static int redkontrol=0;
  public int yon=2;
  //yon=1 potasolu
  //yon=2 potaonu
 // yon=3 potsasagı
  public int dr=1;
  public int atmakontrol=0;
  /*Ultrasonic ultra = new Ultrasonic(1,1);*/
 public Joystick xbox = new Joystick(0);
 public Joystick stick = new Joystick(1);
  VictorSP leftMotor = new VictorSP(0);
  VictorSP rightMotor = new VictorSP(1);
  VictorSP topalma = new VictorSP(2);
  VictorSP topatmasol = new VictorSP(3);
  VictorSP topatmasag = new VictorSP(4); 
  VictorSP renkcarki = new VictorSP(5);
  VictorSP asansor1 = new VictorSP(6);
  VictorSP asansor2 = new VictorSP(7);
  Timer carktimer = new Timer();
  Timer topatmatimer = new Timer();
  Timer ototimer = new Timer();
  DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
  SpeedControllerGroup asansor = new SpeedControllerGroup(asansor1,asansor2);
  DigitalInput  limitanahtarialt = new DigitalInput(0); 
  DigitalInput  limitanahtariust = new DigitalInput(1); 
 
  
  
  @Override
  public void robotInit() {

  
  }
 

  @Override
  public void robotPeriodic() {
   /* double mesafe = ultra.getRangeInches()*2.54f/100;*/
  
    /*NetworkTableInstance table = NetworkTableInstance.getDefault();
     NetworkTable cameraTable = table.getTable("chameleon-vision").getSubTable("ps3-eye camera");
     NetworkTableEntry Targetyaw = cameraTable.getEntry("Targetyaw");
    NetworkTableEntry isDriverMode = cameraTable.getEntry("driver_mode");
double kayma = cameraTable.getEntry("Targetyaw").getDouble(0);
SmartDashboard.putNumber("TKAYMA",kayma);*/

  }


  @Override
  public void autonomousInit() {
   ototimer.reset();
   ototimer.start();

  }

  
  @Override
  public void autonomousPeriodic() {
    switch(yon){
case 1:

if(ototimer.get()<1.50){
  topatmasag.set(1);
topatmasol.set(-1);
}
else if(ototimer.get()>1.50 & ototimer.get()<4.00 ){
  topalma.set(-0.6);
  topatmasag.set(0.9);
  topatmasol.set(-0.9);
  }
  else if(ototimer.get()>4.0 & ototimer.get()<5.00){
    leftMotor.set(0.3);
    rightMotor.set(-0.3);
  }
  else if(ototimer.get()>5.00 & ototimer.get()<6.50){
    leftMotor.set(0.3);
    rightMotor.set(-0.3);
  }
  else {
    topalma.set(0);
  topatmasag.set(0);
  topatmasol.set(0);
  leftMotor.set(0);
    rightMotor.set(0);
  }
break;
case 2:

if(ototimer.get()<1.50){
  topatmasag.set(1);
topatmasol.set(-1);
}
else if(ototimer.get()>1.50 & ototimer.get()<4.00 ){
topalma.set(-0.6);
topatmasag.set(1);
topatmasol.set(-1);
}
else if(ototimer.get()>4.0 & ototimer.get()<5.00){
  leftMotor.set(0.3);
  rightMotor.set(-0.3);
}
else if(ototimer.get()>5.00 & ototimer.get()<6.50){
  leftMotor.set(0.3);
  rightMotor.set(-0.4);
}
else {
  topalma.set(0);
topatmasag.set(0);
topatmasol.set(0);
leftMotor.set(0);
  rightMotor.set(0);
}

break;
case 3:                                                                                                                         
if(ototimer.get()<1.50){
  topatmasag.set(1);
topatmasol.set(-1);
}
else if(ototimer.get()>1.50 & ototimer.get()<4.00 ){
  topalma.set(-0.6);
  topatmasag.set(0.9);
  topatmasol.set(-0.9);
  }
else if(ototimer.get()>4.00 & ototimer.get()<5.20){
  leftMotor.set(0.5);
  rightMotor.set(-0.3);
}
else if(ototimer.get()>5.20 & ototimer.get()<6.00){
  leftMotor.set(0.3);
  rightMotor.set(-0.3);
}
else {
  topalma.set(0);
topatmasag.set(0);
topatmasol.set(0);
leftMotor.set(0);
  rightMotor.set(0);
}

break;
    }

  }


  @Override
  public void teleopPeriodic() {
 
    if(xbox.getRawButton(5))/*Sol Yassı Düğme*/{dr=1;}
    else if(xbox.getRawButton(6))/*Sağ Yassı Düğme*/{dr=2;} 

    if(dr==1){drive.arcadeDrive(xbox.getY(),xbox.getX());} //d
    else if(dr==2){drive.arcadeDrive(-xbox.getY(),xbox.getX());} //r
 
   
     
    if(xbox.getRawButton(4))/*Button[Y]*/{
        }  
        
    if(xbox.getRawButton(1))/*Button[A]*/{
      topalma.set(-0.68);
      atmakontrol=0;
    }
    else if(xbox.getRawButton(2))/*Button[B]*/{
      topalma.set(0.8);
      atmakontrol=0;
    }
    
   else if(xbox.getRawButton(3))/*Button[X]*/{
      if(atmakontrol==0){
        atmakontrol=177;
     topatmatimer.reset();
     topatmatimer.start();
      }
      if(topatmatimer.get()>1.50){
      topatmasol.set(-0.8);
      topatmasag.set(0.8);
      topalma.set(-0.6);
    }
    else{
      topatmasol.set(-0.8);
      topatmasag.set(0.8);
    }
  }

  else {
    topatmasag.set(0);
    topalma.set(0);
    topatmasol.set(0);
  }  

    if(stick.getRawButton(9))/*Orta Tuş Üst*/{
      if(limitanahtariust.get()==true){
    
        asansor.stopMotor();
        System.out.println("asonsor durdu");
      }
      else {
        asansor.set(-12);
        System.out.println("asansor iniyor");
      }
    }
    else if(stick.getRawButton(10))/*Orta Tuş Üst*/{
      if(limitanahtarialt.get()==true){
    
        asansor.stopMotor();
        System.out.println("asansor durdu");
      }
      else {
        asansor.setVoltage(12);
        System.out.println("asansor kalkıyor");
      }
    
    }
    else {
      asansor.set(0);
    }
    if(xbox.getRawButton(4)){
      renkcarki.set(0.4);
    }else {
      renkcarki.set(0);
    }
  }

  @Override
  public void testPeriodic() {
  }
}