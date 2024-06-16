public class PlayArea extends EndConditions{
    static char[][] area = new char[3][3];
    static char[] XO = {'X', 'O'};

    static void display() {
        StringBuilder s1;
        StringBuilder s2 = new StringBuilder("-----");
        for (int i = 0; i < 3; i++) {
            s1 = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                s1.append(area[i][j]).append("|");
            }
            s1.deleteCharAt(s1.length() - 1);
            System.out.println(s1);
            if (i != 2)
                System.out.println(s2);
        }
    }

    static void place(int[] indices, char ch) {
        int i = indices[0];
        int j = indices[1];
        if (area[i][j] == '\0')
            area[i][j] = ch;
    }
}