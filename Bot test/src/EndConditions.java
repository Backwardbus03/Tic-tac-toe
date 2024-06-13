public class EndConditions {
    static String WinConditions(String[][] strArr) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                String win = switch (strArr[i][j]) {
                    case "0" -> strArr[0][0] + strArr[0][1] + strArr[0][2];
                    case "1" -> strArr[1][0] + strArr[1][1] + strArr[1][2];
                    case "2" -> strArr[2][0] + strArr[2][1] + strArr[2][2];
                    case "3" -> strArr[0][0] + strArr[1][0] + strArr[2][0];
                    case "4" -> strArr[0][1] + strArr[1][1] + strArr[2][1];
                    case "5" -> strArr[0][2] + strArr[1][2] + strArr[2][2];
                    case "6" -> strArr[0][0] + strArr[1][1] + strArr[2][2];
                    case "7" -> strArr[0][2] + strArr[1][1] + strArr[2][0];
                    default -> null;
                };
                if (win.equals("XXX"))
                    return "X";
                else if (win.equals("OOO"))
                    return "O";
            }
        }
        for(int n = 0; n < 3; n++) {
            for(int m = 0; m < 3; m++) {
                if (strArr[n][m].equals("1")||strArr[n][m].equals("2")||strArr[n][m].equals("3")||
                        strArr[n][m].equals("4")||strArr[n][m].equals("5")||strArr[n][m].equals("6")||
                        strArr[n][m].equals("7")||strArr[n][m].equals("8")||strArr[n][m].equals("9"))
                    break;
                else if (strArr[n][m].equals(""))
                    return "draw";
            }
        }
}
