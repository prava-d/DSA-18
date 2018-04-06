import java.util.*;

public class NQueens {


    /**
     * Checks the 45° and 1s35° diagonals for an existing queen. For example, if the board is a 5x5
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
            if (board[y][x] == 'Q') return false;
            x++;
            y--;
        }
        return true;
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

    public static List<char[][]> solve(char[][] ans, int r, int[] cols, List<char[][]> current) {
        if (r == ans.length) {
            current.add(copyOf(ans));
            return current;
        }

        for (int i = 0; i < ans.length; i++) {
            if (!checkDiagonal(ans, r, i) && cols[i] == 0) {
                cols[i] = 1;
                ans[r][i] = 'Q';
                solve(ans, r+1, cols, current);
                ans[r][i] = '.';
                cols[i] = 0;

            }
        }
        return current;

    }



    public static List<char[][]> nQueensSolutions(int n) {

        List<char[][]> answers = new ArrayList<>();
        char[][] qs = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                qs[i][j] = '.';
            }
        }

        int[] cols = new int[n];
        answers = solve(qs, 0, cols, answers);
        return answers;
    }

}
