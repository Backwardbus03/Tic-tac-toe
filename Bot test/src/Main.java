import java.util.Random;
import java.util.Scanner;

public class Main extends PlayArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        do {
            System.out.println("Menu: \n1.Multiplayer \n2.Against Bot\n0.Exit\nEnter your choice:");
            ch = scanner.nextInt();
            switch (ch) {
                case 0:
                    System.out.println("Thank you!");
                    break;
                case 1:
                    Random rand = new Random();
                    int i = rand.nextInt(0, 2);
                    Player p1 = new Player(XO[i]);
                    Player p2 = new Player(XO[1 - i]);

                    String str = winConditions(area);
                    while (str.isEmpty()) {
                        display();
                        place(p1.readIndices(), p1.type);
                        display();
                        str = winConditions(area);
                        if (!str.isEmpty())
                            break;
                        place(p2.readIndices(), p2.type);
                        str = winConditions(area);
                    }
                    System.out.println(str);
                    area = new char[3][3];
                    break;
                case 2:
                    Bot bot = new Bot('X', 'O');
                    bot.playAgainstBot();
                    break;
            }
        } while (ch != 0);
    }
}