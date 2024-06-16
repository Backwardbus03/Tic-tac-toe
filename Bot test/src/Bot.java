import java.util.HashMap;

public class Bot extends PlayArea{
    char ai;
    Player human;
    HashMap<Character, Integer> scores = new HashMap<>();

    Bot(char a, char h) {
        ai = a;
        human = new Player(h);
        scores.put('X', 1);
        scores.put('O', -1);
        scores.put('D', 0);
    }

    int minimax(char[][] board, int depth, boolean isMaximising) {
        int bestScore;
        if(!winConditions(board).isEmpty())
            return scores.get(winConditions(board).charAt(0));
        else {
            if(isMaximising) {
                bestScore = Integer.MIN_VALUE;
                for(int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == '\0') {
                            board[i][j] = ai;
                            int score = minimax(board, depth + 1, false);
                            bestScore = Math.max(bestScore, score);
                            board[i][j] = '\0';
                        }
                    }
                }
            } else {
                bestScore = Integer.MAX_VALUE;
                for(int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == '\0') {
                            board[i][j] = human.type;
                            int score = minimax(board, depth + 1, true);
                            bestScore = Math.min(bestScore, score);
                            board[i][j] = '\0';
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    void bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (area[i][j] == '\0') {
                    place(new int[]{i, j}, ai);
                    int score = minimax(area, 0, false);
                    if (bestScore < score) {
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                    area[i][j] = '\0';
                }
            }
        }
        place(bestMove, ai);
    }

    void playAgainstBot() {
        String str = winConditions(area);
        while(str.isEmpty()) {
            bestMove();
            display();
            str = winConditions(area);
            if(!str.isEmpty())
                break;
            place(human.readIndices(), human.type);
            display();
            str = winConditions(area);
        }
        System.out.println(str);
        area = new char[3][3];
    }
}
