package divide_and_conquer;

import java.util.*;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO

        ArrayList<Point> sl = new ArrayList<Point>();

        if (B.length==0) {
            return sl;
        }

        else if(B.length == 1) {
            sl.add(new Point(B[0].l, B[0].h));
            sl.add(new Point(B[0].r, 0));
            return sl;
        }

        else {
            int l = 0;
            int r = B.length - 1;
            int m = B.length/2;

            Building[] left = Arrays.copyOfRange(B, l, m);
            Building[] right = Arrays.copyOfRange(B, m, r + 1);

            return mergeHelper(skyline(left), skyline(right));
        }

    }

    private static List<Point> mergeHelper(List<Point> sl1, List<Point> sl2) {
        int idx1 = 0;
        int idx2 = 0;
        int maxheight = 0;
        int height1 = 0;
        int height2 = 0;

        int ct = 0;

        ArrayList<Point> sl = new ArrayList<Point>();

        while(idx1 < sl1.size() && idx2 < sl2.size()) {

            if (sl1.get(idx1).x == sl2.get(idx2).x) {
                height1 = sl1.get(idx1).y;
                height2 = sl2.get(idx2).y;
                maxheight = Math.max(height1, height2);

                if (sl.size() > 0) {
                    if (maxheight != sl.get(ct - 1).y) {
                        sl.add(new Point(sl1.get(idx1).x, maxheight));
                        ct++;
                    }
                }

                else {
                    sl.add(new Point(sl1.get(idx1).x, maxheight));
                    ct++;
                }

                idx1++;
                idx2++;
            }

            else if (sl1.get(idx1).x < sl2.get(idx2).x) {
                height1 = sl1.get(idx1).y;
                maxheight = Math.max(height1, height2);

                if (sl.size() > 0) {
                    if (maxheight != sl.get(ct - 1).y) {
                        sl.add(new Point(sl1.get(idx1).x, maxheight));
                        ct++;
                    }
                }

                else {
                    sl.add(new Point(sl1.get(idx1).x, maxheight));
                    ct++;
                }

                idx1++;
            }

            else {
                height2 = sl2.get(idx2).y;
                maxheight = Math.max(height1, height2);

                if (sl.size() > 0) {
                    if (maxheight != sl.get(ct - 1).y) {
                        sl.add(new Point(sl2.get(idx2).x, maxheight));
                        ct++;
                    }
                }

                else {
                    sl.add(new Point(sl2.get(idx2).x, maxheight));
                    ct++;
                }

                idx2++;
            }
        }

        while (idx1 < sl1.size()) {
            sl.add(sl1.get(idx1));
            idx1++;
        }

        while (idx2 < sl2.size()) {
            sl.add(sl2.get(idx2));
            idx2++;
        }

        return sl;
    }
}

