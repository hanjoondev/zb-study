package leetcode;

public class L00026 {
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
}
