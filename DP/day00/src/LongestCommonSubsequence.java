import java.util.Arrays;

/*
1. Define subproblem: # of common subsequence for subset of strings
2. Guess: Do we add the one before as a common subsequence (for both strings)
3. Recurrence relation: max(comparison of one subset, comparison of another subset)
4. Recurse/memoize: store lengths
5. Solve original problem: keep on adding when comparing more of string
 */

public class LongestCommonSubsequence {

    // Runtime: The same as below?
    // Space: n = length of string1, m = length of string2 -> O(n*m);
    public static int LCS(String S1, String S2) {
        int[][] memo = new int[S1.length() + 1][S2.length() + 1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return LCShelper(S1.toCharArray(), S2.toCharArray(), memo);
    }

    public static int LCShelper(char[] s1, char[] s2, int[][] memo) {

        char[] s1copy = s1;
        char[] s2copy = s2;
        char[] s1subset;
        char[] s2subset;

        if (s1.length == 0 || s2.length == 0) {
            return 0;
        }

        if(memo[s1.length][s2.length] != -1) {
            return memo[s1.length][s2.length];
        }

        if (s1copy[s1copy.length-1] == s2copy[s2copy.length-1]) {
            s1subset = Arrays.copyOfRange(s1copy, 0, s1copy.length-1);
            s2subset = Arrays.copyOfRange(s2copy, 0, s2copy.length-1);

            memo[s1.length][s2.length] = LCShelper(s1subset, s2subset, memo) + 1;
            return memo[s1.length][s2.length];
        }

        else {
            s1subset = Arrays.copyOfRange(s1copy, 0, s1copy.length-1);
            s2subset = Arrays.copyOfRange(s2copy, 0, s2copy.length);

            int firstcomp = LCShelper(s1subset, s2subset, memo);

            s1subset = Arrays.copyOfRange(s1copy, 0, s1copy.length);
            s2subset = Arrays.copyOfRange(s2copy, 0, s2copy.length - 1);

            int secondcomp = LCShelper(s1subset, s2subset, memo);

            memo[s1.length][s2.length] = Math.max(firstcomp, secondcomp);

            return memo[s1.length][s2.length];
        }

    }
}