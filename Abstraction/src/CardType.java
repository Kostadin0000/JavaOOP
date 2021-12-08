public enum CardType {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private int value;

    CardType(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

}
