package Team.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> players;
    Player striker;
    Player nonStriker;

    public PlayerBattingController(Queue<Player> playing11) {
        this.players = new LinkedList<>();
        this.players.addAll(playing11);
    }

    public void getNextPlayer(){
        if(players.isEmpty()){
            System.out.println("All out");
            return;
        }

        if (striker == null) {
            striker = players.poll();
        }

        if (nonStriker == null) {
            nonStriker = players.poll();
        }

    }
    public Player getStriker() {
        return striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setStriker(Player playerDetails) {
        striker = playerDetails;
    }

    public void setNonStriker(Player playerDetails) {
        nonStriker = playerDetails;
    }

}
