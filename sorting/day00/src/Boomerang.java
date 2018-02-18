import java.util.*;

public class Boomerang {


    public static int numberOfBoomerangs(int[][] points) {
        // TODO
        HashMap<Double, Integer> distances = new HashMap<>();
        int n = 0;

        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                double ptDist = dist(points[i], points[j]);

                if (distances.containsKey(ptDist)) {
                    distances.put(ptDist, distances.get(ptDist) + 1);
                }
                else {
                    distances.put(ptDist, 1);
                }
            }

            for (Integer k : distances.values()) {
                n = n + k * (k - 1);
            }

            distances.clear();

        }

        return n;
    }

    public static double dist(int[] x, int[] y) {
        return  Math.round(Math.pow((x[0]-y[0]), 2) + Math.pow((x[1]-y[1]), 2));
    }
}

