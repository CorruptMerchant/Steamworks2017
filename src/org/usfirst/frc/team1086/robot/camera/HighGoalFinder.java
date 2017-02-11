package org.usfirst.frc.team1086.robot.camera;

import edu.wpi.first.wpilibj.PIDSourceType;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HighGoalFinder extends CameraCalculator {
    public HighGoalFinder(){
        super(Constants.HIGH_GOAL_HEIGHT);
        System.out.println("Contructed!");
    }
    @Override public void validateTargets(){
        visionObjects = new ArrayList(visionObjects.stream().filter(s -> s.solidity > 0.4 && s.aspectRatio > 1.5).collect(Collectors.toList()));
    }
    @Override public boolean estimationIsGood(){
        return visionObjects.size() == 2 && distance >= 0 && distance <= 240 && Math.abs(angle) < Math.PI / 2;
    }
    @Override public void setPIDSourceType(PIDSourceType pidSource){}
    @Override public PIDSourceType getPIDSourceType(){
        return PIDSourceType.kDisplacement;
    }
}