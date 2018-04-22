import java.util.*;

class Gap implements Comparable<Gap> {
    int start;
    int end;

    public Gap(int s, int e) {
        start = s;
        end = e;
    }

    public int gapSize() {
        return end - start - 1;
    }

    @Override
    public int compareTo(Gap g) {
        return this.gapSize() - g.gapSize();
    }

}


public class BarnRepair {

    public static int solve(int M, int[] occupied) {
        // TODO

        PriorityQueue<Gap> gaps = new PriorityQueue<>();
        Arrays.sort(occupied);
        int blocked = occupied.length;

        for (int i = 1; i < occupied.length; i++) {
            if ((occupied[i] - occupied[i - 1] > 1)) {
                gaps.add(new Gap(occupied[i - 1], occupied[i]));
            }
        }

        int numBoards = gaps.size() + 1;

        while (numBoards > M) {
            Gap g = gaps.poll();

            blocked += g.gapSize();

            numBoards--;
        }

        return blocked;
    }
}