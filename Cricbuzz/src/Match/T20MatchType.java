package Match;

public class T20MatchType implements MatchType{
    @Override
    public int getMaxOvers() {
        return 20;
    }

    @Override
    public int getMaxOversPerBowler() {
        return 4;
    }
}
