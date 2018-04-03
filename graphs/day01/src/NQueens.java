import java.util.ArrayList;
import java.util.List;

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

    public static boolean checkRow(char[][] board, int r) {

        for (int i = 0; i < board[0].length; i++) {
            if (board[i][r] == 'Q') return true;
        }
        return false;
    }

    public static boolean checkCol(char[][] board, int c) {

        for (int i = 0; i < board.length; i++) {
            if (board[c][i] == 'Q') return true;
        }
        return false;
    }

    public static boolean checkValid(char[][] board, int r, int c) {

        return !(checkDiagonal(board, r, c) && checkRow(board, r) && checkCol(board, c));
    }

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; i < board[0].length; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'Q';
                    if (checkValid(board, j, i)) {
                        if (solve(board)) {
                            return true;
                        }
                        else {
                            board[i][j] = '.';
                        }
                    }
                }

                return false;
            }
        }

        return true;

    }



    public static List<char[][]> nQueensSolutions(int n) {
        // TODO
        List<char[][]> answers = new ArrayList<>();
        return answers;
    }

}
