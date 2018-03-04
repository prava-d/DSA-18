import java.util.*;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        // TODO

        Arrays.sort(arr);
        int count = 0;
        int diff;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hmap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                diff = sum - (arr[i] + arr[j]);

                if (hmap.containsKey(diff)) {
                    int temp = hmap.get(diff);

                    if(temp != i && temp != j) {
                        count++;
                    }
                }
            }
        }

        count = count / 3;
        return count;
    }
}
