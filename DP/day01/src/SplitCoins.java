import java.util.*;

public class SplitCoins {

    public static int splitCoins(int[] coins) {
        // TODO
        int tot = 0;

        for (int i = 0; i < coins.length; i++) {
            tot += coins[i];
        }

        int[][] memo = new int[coins.length][tot];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        return SChelper(coins, 0, tot, coins.length, memo);
    }

    public static int SChelper(int[] coins, int s1, int tot, int idx, int[][] memo) {

        int s2 = tot - s1;

        if (idx == 0) {
            return Math.abs(s1 - s2);
        }

        if (memo[idx - 1][s1] != -1) {
            return memo[idx - 1][s1];
        }

        memo[idx - 1][s1] = Math.min(SChelper(coins, s1, tot, idx - 1, memo), SChelper(coins, s1 + coins[idx - 1], tot, idx - 1, memo));

        return memo[idx - 1][s1];
    }
}
