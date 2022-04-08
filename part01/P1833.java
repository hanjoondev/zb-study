import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1833 {
    public static void solution(int[] arr, int k, int x) {
        Arrays.sort(arr);
        Map<Integer, Integer> m = IntStream.range(0, arr.length)
            .boxed().collect(Collectors.toMap(i -> arr[i],
                                              i -> Math.abs(x - arr[i])))
            .entrySet().stream().sorted(Entry.comparingByValue())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                      (e1, e2) -> e1, LinkedHashMap::new));
        List<Integer> perSpec = m.keySet().stream().limit(k).collect(Collectors.toList());
        Collections.sort(perSpec);  // as per the example, not the specification
        System.out.println(perSpec);
    }

/* leetcode submission
    // Source: 442. Find All Duplicates in an Array https://leetcode.com/problems/find-all-duplicates-in-an-array/
    // Submission detail: https://leetcode.com/submissions/detail/676527334/
    //     Runtime Error (5 / 63 test cases passed.)
    //     TODO: fix it
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Arrays.sort(arr);
        Map<Integer, Integer> m = IntStream.range(0, arr.length)
            .boxed().collect(Collectors.toMap(i -> arr[i],
                                              i -> Math.abs(x - arr[i])))
            .entrySet().stream().sorted(Entry.comparingByValue())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                      (e1, e2) -> e1, LinkedHashMap::new));
        List<Integer> perSpec = m.keySet().stream().limit(k).collect(Collectors.toList());
        Collections.sort(perSpec);
        return perSpec;
    }
*/

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);
    }
}
