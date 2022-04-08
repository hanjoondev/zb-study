import java.util.ArrayList;

public class P1832 {
    public static ArrayList<Integer> solution(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    nums[i] *= -1;
                    arr.add(nums[j]);
                }
            }
        }
        return arr;
    }

/* leetcode submission
    // Source: 442. Find All Duplicates in an Array https://leetcode.com/problems/find-all-duplicates-in-an-array/
    // Submission detail: https://leetcode.com/submissions/detail/676525781/
    //     Time Limit Exceeded (24 / 28 test cases passed.)
    //     TODO: fix it
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    nums[i] *= -1;
                    arr.add(nums[j]);
                }
            }
        }
        return arr;
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
