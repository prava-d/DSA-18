import java.util.*;

/**
 * Have a pivot, pivot is something from the other array (e.g. get locks and keys),
 */
public class LocksAndKeys {

    private static void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    static char[][] locksAndKeys(char[] locks, char[] keys) {
        // TODO: Return a 2d char array, where result[0] is the sorted locks, and result[1] is the sorted keys
        char[][] result = new char[2][];
        quicksort(keys, locks, 0, locks.length - 1);
        result[0] = locks;
        result[1] = keys;
        return result;
    }

    private static int partition(char[] array, int left, int right, char pivot) {
        int temp = left;

        for(int i = left; i < right; i++) {

            if(array[i] < pivot) {
                swap(array, i, temp);
                temp++;
            }
            else if(array[i] == pivot) {
                swap(array, i, right);
                i--;
            }
        }

        swap(array, temp, right);
        return temp;
    }

    private static void quicksort(char[] a, char[] b, int left, int right) {
        if (left < right) {
            int temp = partition(a, left, right, b[right]);
            int temp1 = partition(b, left, right, a[temp]);

            quicksort(a, b, left, temp - 1);
            quicksort(a, b, temp + 1, right);
        }
    }
}




