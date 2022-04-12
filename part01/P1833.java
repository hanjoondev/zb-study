import java.util.Arrays;

public class P1833 {
    public static void solution(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l + 1 > k)
            if (Math.abs(x - arr[l]) > Math.abs(x - arr[r]))
                l++;
            else
                r--;
        System.out.println(Arrays.stream(arr).boxed().toList().subList(l, r + 1));
    }

/* leetcode submission
    // Source: 658. Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/
    // Submission detail: https://leetcode.com/submissions/detail/678643249/
    //     Runtime: 7 ms, faster than 54.20% of Java online submissions for Find K Closest Elements.
    //     Memory Usage: 44.5 MB, less than 84.01% of Java online submissions for Find K Closest Elements.
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l + 1 > k)
            if (Math.abs(x - arr[l]) > Math.abs(x - arr[r]))
                l++;
            else
                r--;
        return Arrays.stream(arr).boxed().toList().subList(l, r + 1);
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
