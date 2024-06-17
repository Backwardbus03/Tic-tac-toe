import java.util.Scanner;

public class Player {
    char type;

    Player(char ch) {
        type = ch;
    }

    int[] readIndices() {
        int i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first index:");
        i = sc.nextInt();
        System.out.println("Enter the second index:");
        j = sc.nextInt();
        return new int[]{i, j};
    }
}