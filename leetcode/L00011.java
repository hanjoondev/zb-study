package leetcode;

public class L00011 {
    public int maxArea(int[] height) {
        int w = 0, l = 0, r = height.length - 1;
        while (l < r) {
            w = Math.max(Math.min(height[l], height[r]) * (r - l), w);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return w;
    }
}
