public class EndConditions {
    static boolean posIsFull(char[][] arr) {
        for (char[] chars : arr)
            for (int j = 0; j < arr.length; j++)
                if (chars[j] == '\0')
                    return false;
        return true;
    }

    static String winConditions(char[][] strArr) {
        StringBuilder win;
        for (int i = 0; i < 8; i++) {
            win = new StringBuilder();
            switch (i) {
                case 0 -> win.append(strArr[0][0]).append(strArr[0][1]).append(strArr[0][2]);
                case 1 -> win.append(strArr[1][0]).append(strArr[1][1]).append(strArr[1][2]);
                case 2 -> win.append(strArr[2][0]).append(strArr[2][1]).append(strArr[2][2]);
                case 3 -> win.append(strArr[0][0]).append(strArr[1][0]).append(strArr[2][0]);
                case 4 -> win.append(strArr[0][1]).append(strArr[1][1]).append(strArr[2][1]);
                case 5 -> win.append(strArr[0][2]).append(strArr[1][2]).append(strArr[2][2]);
                case 6 -> win.append(strArr[0][0]).append(strArr[1][1]).append(strArr[2][2]);
                case 7 -> win.append(strArr[0][2]).append(strArr[1][1]).append(strArr[2][0]);
            }
            if (win.toString().equals("XXX"))
                return "X wins";
            else if (win.toString().equals("OOO"))
                return "O wins";
        }

        if (posIsFull(strArr))
            return "Draw";

        return "";
    }
}
