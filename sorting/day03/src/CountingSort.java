import java.util.*;

public class CountingSort {

    /**
<<<<<<< HEAD
     * Use counting sort to sort positive integer array A.
     * Runtime: O(n + k)
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
>>>>>>> 6ef5cd060b5c2a2e260f93ca04e6a62dc4bfacbc
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // TODO
        int maxelem = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] > maxelem) {
                maxelem = A[i];
            }
        }

        int[] temp = new int[maxelem + 1];

        for (int i = 0; i < A.length; i++) {
            temp[A[i]] = temp[A[i]] + 1;
        }

        int idx = 0;
        for (int i = 0; i < temp.length; i++) {
            while(temp[i] > 0) {
                temp[i] = temp[i] - 1;
                A[idx] = i;
                idx++;
            }
        }

    }

}
