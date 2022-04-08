public class P1835 {
    public static int solution(int[] h) {
        int area = 0, lmax = 0, rmax = 0, l = 0, r = h.length - 1;
        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] > lmax)
                    lmax = h[l];
                else
                    area += lmax - h[l];
                l++;
            } else {
                if (h[r] > rmax)
                    rmax = h[r];
                else
                    area += rmax - h[r];
                r--;
            }
        }
        return area;
    }

/* leetcode submission
    // Source: 42. Trapping Rain Water https://leetcode.com/problems/trapping-rain-water/
    // Submission detail: https://leetcode.com/submissions/detail/676531442/
    //     Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
    //     Memory Usage: 43 MB, less than 87.06% of Java online submissions for Trapping Rain Water.
    public int trap(int[] h) {
        int area = 0, lmax = 0, rmax = 0, l = 0, r = h.length - 1;
        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] > lmax)
                    lmax = h[l];
                else
                    area += lmax - h[l];
                l++;
            } else {
                if (h[r] > rmax)
                    rmax = h[r];
                else
                    area += rmax - h[r];
                r--;
            }
        }
        return area;
    }
*/

    public static void main(String[] args) {
        // Test code
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(height));

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(solution(height));
    }
}
