public class Problems {

    public static int leastSum(int[] A) {
        countingSort(A);

        String t1 = "";
        String t2 = "";

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                t1 += A[i];
            } else {
                t2 += A[i];
            }
        }

        int r1;
        int r2;

        if (t1.equals("")) {
            r1 = 0;
        } else {
            r1 = Integer.parseInt(t1);
        }

        if (t2.equals("")) {
            r2 = 0;
        } else {
            r2 = Integer.parseInt(t2);
        }

        int sum = r1 + r2;

        return sum;
    }

    private static void countingSort(int[] A) {
        int k = get_max(A);
        int[] buckets = new int[k + 1];
        for (int i = 0; i < A.length; i++) {
            buckets[A[i]]++;
        }
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                buckets[i]--;
                A[j] = i;
                j++;
            }
        }
    }

    static private int get_max(int[] A) {
        if (A.length == 0)
            return 0;
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
}
