import java.util.*;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> permutations = new LinkedList<>();
        //return permutations;

        Set<Integer> Aset = new HashSet<Integer>(A);

        backtrack(new LinkedList<Integer>(), Aset, permutations);

        //System.out.println(permutations);
        return permutations;

    }

}
