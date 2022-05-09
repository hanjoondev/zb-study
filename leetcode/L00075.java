package leetcode;

public class L00075 {
    public void sortColors(int[] nums) {
        qs(nums, 0, nums.length - 1);
    }

    private static void qs(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = nums[start], lo = start + 1, hi = end;
        while (true) {
            while (lo <= hi && nums[lo] <= pivot) lo++;
            while (lo <= hi && nums[hi] > pivot) hi--;
            if (lo > hi) break;
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
        }
        int tmp = nums[start];
        nums[start] = nums[hi];
        nums[hi] = tmp;
        qs(nums, start, hi - 1);
        qs(nums, hi + 1, end);
    }
}
