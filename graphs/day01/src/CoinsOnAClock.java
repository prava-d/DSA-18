import java.util.ArrayList;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        List<char[]> result = new ArrayList<>();
        char[] answers = new char[hoursInDay];
        return solve(result, answers, pennies, nickels, dimes, hoursInDay, 0, 0);
    }



    public static List<char[]> solve(List <char[]> current, char[] ans, int p, int n, int d, int h, int idx, int count) {

        if (count == h) {
            char[] temp = new char[ans.length];
            System.arraycopy(ans, 0, temp, 0, ans.length);
            current.add(temp);
            return current;
        }



        for (int i = 0; i < 3; i++) {
            int curridx;
            if (ans[idx] != 'p' && ans[idx] != 'n' && ans[idx] != 'd') {
                if (i == 0 && p > 0) {
                    ans[idx] = 'p';
                    p--;
                    curridx = (idx + 1) % ans.length;

                    solve(current, ans, p, n, d, h, curridx, count + 1);
                    ans[idx] = 0;
                    p++;
                }

                if (i == 1 && n > 0) {
                    ans[idx] = 'n';
                    n--;
                    curridx = (idx + 5) % ans.length;

                    solve(current, ans, p, n, d, h, curridx, count + 1);
                    ans[idx] = 0;
                    n++;
                }

                if (i == 2 && d > 0) {
                    ans[idx] = 'd';
                    d--;
                    curridx = (idx + 10) % ans.length;

                    solve(current, ans, p, n, d, h, curridx, count + 1);
                    ans[idx] = 0;
                    d++;
                }
            }
        }
        return current;
    }

}

