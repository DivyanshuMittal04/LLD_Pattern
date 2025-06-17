package model;

public class Player {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPeice getSymbol() {
        return symbol;
    }

    public void setSymbol(PlayingPeice symbol) {
        this.symbol = symbol;
    }

    String name;
    PlayingPeice symbol;
    public Player(String name, PlayingPeice symbol){
        this.name = name;
        this.symbol = symbol;
    }
}
