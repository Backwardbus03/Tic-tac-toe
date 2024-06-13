import java.util.Random;

public class Main extends PlayArea{
    public static void main(String[] args) {
        Random rand = new Random();
        int i = rand.nextInt(0, 2);
        Player p1 = new Player(XO[i]);
        Player p2 = new Player(XO[1 - i]);

        String str = winConditions(area);
        while(str.isEmpty()) {
            display();
            place(p1.readIndices(), p1.type);
            display();
            str = winConditions(area);
            if(!str.isEmpty())
                break;
            place(p2.readIndices(), p2.type);
            str = winConditions(area);
        }
        System.out.println(str);
    }
}