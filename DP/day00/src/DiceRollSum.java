public class DiceRollSum {

    /*
    1. Define subproblem: sequence to reach sum of i
    2. Guess: do we add 1 - 6 dice roll next
    3. Recurrence relation: memo[N] = memo[N - 1] +  ... memo[1];
    4. Recurse/memoize: store sequences per sum
    5. Solve original problem: sequences of sum N can be split into individual sum i's
 */


    // Runtime: O(n)
    // Space: O(n)

    public static int diceRollSum(int N) {

        int[] memo = new int[N + 1];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return DRShelper(N, memo);
    }

    public static int DRShelper(int N, int[] memo) {

        if (N == 0) {
            return 1;
        }
        else if (N < 0) {
            return 0;
        }
        else if (memo[N] != -1) {
            return memo[N];
        }

        memo[N] = DRShelper(N - 1, memo) + DRShelper(N - 2, memo) + DRShelper(N - 3, memo) + DRShelper(N - 4, memo) +
        DRShelper(N - 5, memo) + DRShelper(N - 6, memo);

        return memo[N];
    }

}
