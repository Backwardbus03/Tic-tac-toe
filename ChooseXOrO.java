import java.util.*;

public class ChooseXOrO {
    private final char[] XO = {'X', 'O'};
    public char getChar() {
        return XO[new Random().nextInt(2)];
    }
}