package Match;

public class ODIMatchType implements MatchType{
    @Override
    public int getMaxOvers() {
        return 50;
    }

    @Override
    public int getMaxOversPerBowler() {
        return 10;
    }
}
