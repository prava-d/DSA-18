public class EditDistance {

    public static int minEditDist(String a, String b) {
        // TODO: Your code here

        int[][] memo = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length()+1; i++) {
            for (int j = 0; j < b.length()+1 ; j++) {
                memo[i][j] = -1;
            }
        }

        for (int i = 0; i < a.length() + 1; i++) {
            memo[i][0] = i;
        }

        for (int i = 0; i < b.length() + 1; i++) {
            memo[0][i] = i;
        }

        for (int i = 1; i < a.length() + 1; i++) {

            for (int j = 1; j < b.length() + 1; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = 0;
                }

                if (memo[i][j] == -1) {
                    int temp = Math.min(memo[i - 1][j - 1], memo[i][j - 1]);
                    memo[i][j] = Math.min(temp, memo[i - 1][j]) + 1;
                }

                if (memo[i][j] == 0) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
            }
        }

        return memo[a.length()][b.length()];
    }

}
