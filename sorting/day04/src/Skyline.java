import java.util.*;

public class Skyline {

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        int low = 0;
        int high = B.length - 1;

        int mid = (low + high) / 2;

        if (low == high) {

        }

        List<Point> leftS = skyline(Arrays.copyOfRange(B, low, mid));
        List<Point> leftR = skyline(Arrays.copyOfRange(B, low, mid));



        return new ArrayList<>();
    }
}
