package frc.robot;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.RobotState;

public class HubTimingUtil {

    private static boolean didTeamWinAuto=true;    
    private static double gameTime;
    private static boolean hubOpen;
    public void updateGameTime(double time){
        gameTime = time;
    }

    public void updateTeamWonAuto(){
        String WininngAliance= DriverStation.getGameSpecificMessage();
        Optional <Alliance> optionalcurrentAlliance = DriverStation.getAlliance();
        Alliance alliance = optionalcurrentAlliance.orElse(Alliance.Red);

        if (optionalcurrentAlliance.isPresent()){
            //tung tung sahur
        }
        else{
            //another tung tung tung sahur
        }

        if ((WininngAliance.equals("R") && alliance==Alliance.Red) || (WininngAliance.equals("B") && alliance==Alliance.Blue)){
            didTeamWinAuto=true;    
        }

        else{
            didTeamWinAuto=false;    
        }
    }


    public static boolean checkHubCondition(){

        if(RobotState.isAutonomous()){
            return hubOpen=true;
        }

        if(130 <gameTime || gameTime<140){
            return hubOpen=true;
        }

        if((105<gameTime || gameTime<130) && didTeamWinAuto==true){
            return hubOpen=false;
        } else if((105<gameTime || gameTime<130)) {
            return hubOpen=true;
        }

        if((80<gameTime || gameTime<105) && didTeamWinAuto==true){
            return hubOpen=true;
        } else if((80<gameTime || gameTime<105)) {
            return hubOpen=false;
        }

        if((55<gameTime || gameTime<80) && didTeamWinAuto==true){
            return hubOpen=false;
        } else if((55<gameTime || gameTime<80)) {
            return hubOpen=true;
        }
        
        if((30<gameTime || gameTime<55) && didTeamWinAuto==true){
            return hubOpen=true;
        } else if((30<gameTime || gameTime<55)) {
            return hubOpen=false;
        }

        if((30<gameTime|| gameTime<0)){
            return hubOpen=true;
        }
        return hubOpen;
    }
}



