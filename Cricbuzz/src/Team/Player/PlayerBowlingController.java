package Team.Player;

import java.util.*;

public class PlayerBowlingController {
    Deque<Player> bowlers;
    Map<Player,Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player>bowlerList) {
        bowlers = new ArrayDeque<>();
        bowlerVsOverCount = new HashMap<>();
        for (Player bowler : bowlerList) {
            this.bowlers.addLast(bowler);
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {

        Player playerDetails = bowlers.poll();
        if(bowlerVsOverCount.get(playerDetails)+1 == maxOverCountPerBowler) {
            currentBowler = playerDetails;
        }
        else {
            currentBowler = playerDetails;
            bowlers.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }
    }

    public Player getCurrentBowler(){
        return currentBowler;
    }
}
