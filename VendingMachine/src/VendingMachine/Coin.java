package VendingMachine;

public enum Coin {
    ONERUPEE(1),
    TWORUPEE(2),
    FIVERUPEE(5),
    TENRUPEE(10)
    ;

    public int getValue() {
        return value;
    }

    public int value;
    Coin(int value) {
        this.value = value;
    }
}
