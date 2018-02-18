import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(nlogn)
     *
     * Space-complexity: O(n)
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        else {
            int[] L = sort(Arrays.copyOfRange(array, 0, array.length/2));
            int[] R = sort(Arrays.copyOfRange(array, array.length/2, array.length));
            return merge(L, R);
        }
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        int a_idx = 0;
        int b_idx = 0;
        int r_idx = 0;

        while (r_idx < r.length) {
            if (a_idx < a.length && b_idx < b.length) {
                if (a[a_idx] <= b[b_idx]) {
                    r[r_idx] = a[a_idx];
                    a_idx++;
                    r_idx++;
                }
                else {
                    r[r_idx] = b[b_idx];
                    b_idx++;
                    r_idx++;
                }
            }

            else if (a_idx < a.length && !(b_idx < b.length)) {
                r[r_idx] = a[a_idx];
                a_idx++;
                r_idx++;
            }

            else if (!(a_idx < a.length) && b_idx < b.length) {
                r[r_idx] = b[b_idx];
                b_idx++;
                r_idx++;
            }
        }

        return r;
    }

}
