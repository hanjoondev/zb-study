import java.util.ArrayList;
import java.util.Arrays;

public class P1832 {
    public static ArrayList<Integer> solution(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < nums.length; i++) 
            if (nums[i] == nums[i - 1])
                arr.add(nums[i]);
        return arr;
    }

/* leetcode submission
    // Source: 442. Find All Duplicates in an Array https://leetcode.com/problems/find-all-duplicates-in-an-array/
    // Submission detail: https://leetcode.com/submissions/detail/676525781/
    //     Runtime: 26 ms, faster than 20.62% of Java online submissions for Find All Duplicates in an Array.
    //     Memory Usage: 67.9 MB, less than 28.25% of Java online submissions for Find All Duplicates in an Array.
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < nums.length; i++) 
            if (nums[i] == nums[i - 1])
                arr.add(nums[i]);
        return arr;
    }
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
