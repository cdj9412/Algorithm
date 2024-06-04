import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int max = 19;
    static String[][] boardStatus;
    static boolean winCheck;
    static StringBuilder winner;

    static void widthSearch(int row, int col) {
        int maxCol = col + 4;

        if (maxCol >= max)
            return;

        String firstValue = boardStatus[row][col];

        if (firstValue.equals("0"))
            return;

        int count = 0;

        for (int i = col; i <= maxCol; i++) {
            if (firstValue.equals(boardStatus[row][i]))
                count++;
            else
                break;
        }

        if (count == 5) {
            if (col > 0 
                    && firstValue.equals(boardStatus[row][col - 1]))
                return;
            if (maxCol + 1 < max 
                    && firstValue.equals(boardStatus[row][maxCol + 1]))
                return;

            winCheck = true;
            winner.append(firstValue).append("\n").append(row + 1).append(" ").append(col + 1).append("\n");
        }
    }

    static void lengthSearch(int row, int col) {
        int maxRow = row + 4;

        if (maxRow >= max)
            return;

        String firstValue = boardStatus[row][col];

        if (firstValue.equals("0"))
            return;

        int count = 0;

        for (int i = row; i <= maxRow; i++) {
            if (firstValue.equals(boardStatus[i][col]))
                count++;
            else
                break;
        }

        if (count == 5) {
            if (row > 0 
                    && firstValue.equals(boardStatus[row - 1][col]))
                return;
            if (maxRow + 1 < max 
                    && firstValue.equals(boardStatus[maxRow + 1][col]))
                return;

            winCheck = true;
            winner.append(firstValue).append("\n").append(row + 1).append(" ").append(col + 1).append("\n");
        }
    }

    static void diagonalSearch(int row, int col) {
        int maxRow = row + 4;
        int maxCol = col + 4;

        if (maxRow >= max || maxCol >= max)
            return;

        String firstValue = boardStatus[row][col];

        if (firstValue.equals("0"))
            return;

        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (firstValue.equals(boardStatus[row + i][col + i]))
                count++;
            else
                break;
        }

        if (count == 5) {
            if (row > 0 && col > 0 
                    && firstValue.equals(boardStatus[row - 1][col - 1]))
                return;
            if (maxRow + 1 < max && maxCol + 1 < max 
                    && firstValue.equals(boardStatus[maxRow + 1][maxCol + 1]))
                return;

            winCheck = true;
            winner.append(firstValue).append("\n").append(row + 1).append(" ").append(col + 1).append("\n");
            return;
        }

        int minRow = row - 4;
        if (minRow < 0 || maxCol >= max)
            return;

        count = 0;

        for (int i = 0; i < 5; i++) {
            if (firstValue.equals(boardStatus[row - i][col + i]))
                count++;
            else
                break;
        }

        if (count == 5) {
            if (row + 1 < max && col > 0 && firstValue.equals(boardStatus[row + 1][col - 1]))
                return;
            if (minRow - 1 >= 0 && maxCol + 1 < max && firstValue.equals(boardStatus[minRow - 1][maxCol + 1]))
                return;

            winCheck = true;
            winner.append(firstValue).append("\n").append(row + 1).append(" ").append(col + 1).append("\n");
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boardStatus = new String[max][max];

        for (int i = 0; i < max; i++)
            boardStatus[i] = br.readLine().split(" ");

        winner = new StringBuilder();
        winCheck = false;

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                widthSearch(i, j);
                if (winCheck) break;

                lengthSearch(i, j);
                if (winCheck) break;

                diagonalSearch(i, j);
                if (winCheck) break;
            }
            if (winCheck) break;
        }

        if (!winCheck)
            winner.append("0");

        System.out.println(winner.toString().trim());
    }
}