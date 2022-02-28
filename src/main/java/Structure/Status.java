package Structure;

public enum Status {
    EMPTY('.'),
    BLACK('B'),
    WHITE('W');

    private final char symbol;
    Status(char symbol){
        this.symbol=symbol;
    }
    char symbol(){
        return symbol;
    }
}