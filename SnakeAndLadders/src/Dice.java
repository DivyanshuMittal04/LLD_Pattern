import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int minDiceCount = 1;
    private final int maxDiceCount = 6;

    public int rollDice(){
        return ThreadLocalRandom.current().nextInt(minDiceCount, maxDiceCount + 1);
    }
}
