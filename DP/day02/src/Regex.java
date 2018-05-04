public class Regex {

    public static boolean isMatch(String s, String p) {
        // TODO

        if (p.length() == 0 && s.length() == 0)
            return true;

        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];

        for(int i = 0; i < s.length() + 1; i++){
            for(int j= 0; j < p.length() + 1; j++){
                memo[i][j] = false;
            }
        }

        memo[0][0] = true;

        // *, prev is true as well --> set true
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                memo[0][i + 1] = memo[0][i - 1];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {

                if (p.charAt(j - 1) == '*') {

                    if (p.charAt(j - 2) != '.' && p.charAt(j - 2) != s.charAt(i - 1)) {
                        memo[i][j] = memo[i][j - 2];
                    }

                    else if (memo[i - 1][j] || memo[i][j - 1] || memo[i][j - 2]) {
                        memo[i][j] = true;
                    }

                    else {
                        memo[i][j] = false;
                    }

                }

                if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt((j - 1))) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
            }
        }

        return memo[s.length()][p.length()];
    }

}
