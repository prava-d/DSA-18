import java.util.Arrays;

public class BalloonPopping {

    public static int maxPoints(int[] B) {
        // TODO


        int[] newB = new int[B.length + 2];

        newB[0] = 1;
        newB[B.length + 1] = 1;

        for (int i = 1; i < B.length + 1; i++) {
            newB[i] = B[i - 1];
        }

        int[][] memo = new int[newB.length][newB.length];

        memo[0][0] = 0;
        memo[newB.length - 1][newB.length - 1] = 0;

        for (int i = 2; i < memo.length; i++) {
            for (int j = 0; j < memo.length - i; j++) {
                int k = j + i;

                for (int l = j + 1; l < k; l++) {
                    memo[j][k] = Math.max(memo[j][k], newB[j] * newB[l] * newB[k] + memo[j][l] + memo[l][k]);
                }
            }
        }

        return memo[0][memo.length - 1];
    }
}
