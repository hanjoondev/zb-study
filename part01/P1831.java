public class P1831 {
    public static void solution(int[] nums) {
        int last = nums[0], biggest = nums[nums.length - 1];
        System.out.printf("%d" + (last < biggest ? ", " : ""), last);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                System.out.printf("%d" + (nums[i] < biggest ? ", " : "\n"), nums[i]);
                last = nums[i];
            }
        }
    }

/* leetcode submission
    // Source: 26. Remove Duplicates from Sorted Array https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Submission detail: https://leetcode.com/submissions/detail/676521175/
    //     Runtime: 1 ms, faster than 84.98% of Java online submissions for Remove Duplicates from Sorted Array.
    //     Memory Usage: 48.1 MB, less than 31.77% of Java online submissions for Remove Duplicates from Sorted Array.
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[ans] != nums[i]) {
                ans++;
                nums[ans] = nums[i];
            }
        }
        return ++ans;
    }
*/

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
