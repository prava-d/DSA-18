public class DungeonGame {

    public static int minInitialHealth(int[][] map) {

        int x = map.length;
        int y = map[0].length;

        int memo[][] = new int[x][y];

        if (map[x - 1][y - 1] > 0) {
            memo[x - 1][y - 1] = 1;
        }
        else {
            memo[x - 1][y - 1] = Math.abs(map[x - 1][y - 1]) + 1;
        }

        for (int i = x - 2; i >= 0; i--) {
            memo[i][y - 1] = Math.max(memo[i + 1][y - 1] - map[i][y - 1], 1);
        }

        for (int i = y - 2; i >= 0; i--) {
            memo[x - 1][i] = Math.max(memo[x - 1][i + 1] - map[x - 1][i], 1);
        }

        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0; j--) {
                int temp = Math.min(memo[i + 1][j], memo[i][j + 1]);
                memo[i][j] = Math.max(temp - map[i][j], 1);
            }
        }

        return memo[0][0];
    }
}
