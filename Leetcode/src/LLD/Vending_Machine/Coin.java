package LLD.Vending_Machine;

public enum Coin {

    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    private final int value;

    private Coin(int value){
        this.value =value;
    }

    public int getValue(){
        return this.value;
    }

}
