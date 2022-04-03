public class P1815 {
    public static int solution(int[] height) {
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

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }
}
