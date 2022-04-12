import java.util.ArrayList;

public class P1832 {
    public static ArrayList<Integer> solution(int[] n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, len = n.length;
        while (i < len) {
            if (n[i] - 1 == i || n[n[i] - 1] == n[i]) {
                i++;
            } else {
                int t = n[i];
                n[i] = n[n[i] - 1];
                n[t - 1] = t;
            }
        }
        for (int j = 0; j < len; j++)
            if (n[j] != j + 1)
                ans.add(n[j]);
        return ans;
    }

/* leetcode submission
    // Source: 442. Find All Duplicates in an Array https://leetcode.com/problems/find-all-duplicates-in-an-array/
    // Submission detail: https://leetcode.com/submissions/detail/678603228/
    //     Runtime: 8 ms, faster than 68.48% of Java online submissions for Find All Duplicates in an Array.
    //     Memory Usage: 66.2 MB, less than 60.56% of Java online submissions for Find All Duplicates in an Array.
    public List<Integer> findDuplicates(int[] n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        while (i < n.length) {
            if (n[i] - 1 == i || n[n[i] - 1] == n[i]) {
                i++;
            } else {
                int t = n[i];
                n[i] = n[n[i] - 1];
                n[t - 1] = t;
            }
        }
        for (int j = 0; j < n.length; j++)
            if (n[j] != j + 1)
                ans.add(n[j]);
        return ans;
    }
*/

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}
