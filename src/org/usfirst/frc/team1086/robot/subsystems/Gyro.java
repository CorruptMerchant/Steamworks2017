
package org.usfirst.frc.team1086.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SerialPort;

public class Gyro implements PIDSource {
    private static AHRS navX;
    
    public Gyro(){
        if(navX == null){
            try {
                navX = new AHRS(SerialPort.Port.kMXP);
            } catch(Exception e){e.printStackTrace();}
        }
    }
    
    public double getAngle(){
        return navX.getYaw();
    }
    
    public void reset(){
        navX.reset();
    }
    
    @Override public void setPIDSourceType(PIDSourceType pidSource){}
    @Override public PIDSourceType getPIDSourceType(){
        return PIDSourceType.kDisplacement;
    }
    @Override public double pidGet(){
        return getAngle();
    }
   
}