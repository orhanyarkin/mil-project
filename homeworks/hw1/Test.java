package hw1;

import java.util.ArrayList;

public class Test {
    public static void main(String [] args){
        Team teamA=new Team(901,"Godoro Spor");
        teamA.setPlayerList(new ArrayList<>());

        Player player1=new Player(301,"Neset Ertas",45.2);
        player1.setTeam(teamA);
        teamA.getPlayerList().add(player1);

        Player player2=new Player(302,"Mahsuni Serif",36.5);
        player2.setTeam(teamA);
        teamA.getPlayerList().add(player2);

        Player player3=new Player(303,"Erkan Ocakli",71.3);
        player3.setTeam(teamA);
        teamA.getPlayerList().add(player3);

        System.out.println(teamA.getTeamId()+" "+teamA.getTeamName());

        for(Player player : teamA.getPlayerList()){
            System.out.println("\t"+player.getPlayerId()+" "+player.getPlayerName()+" "+player.getAverageScore());
        }
    }
}
