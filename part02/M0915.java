public class M0915 {
    public static int solution(int[][] grid) {
        int ans = 0, h = grid.length, w = grid[0].length;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (grid[r][c] == 1) {
                    int tmp = 4;
                    int[][] nxt = {{r, c + 1}, {r + 1, c}, {r, c - 1}, {r - 1, c}};
                    for (int[] n : nxt)
                        if (n[0] >= 0 && n[0] < h && n[1] >= 0 && n[1] < w && grid[n[0]][n[1]] == 1)
                            tmp--;
                    ans += tmp;
                }
            }
        }
        return ans;
    }

/* leetcode submission
    // Source: 463. Island Perimeter https://leetcode.com/problems/island-perimeter/
    // Submission detail: https://leetcode.com/submissions/detail/676695578/
    //     Runtime: 9 ms, faster than 72.92% of Java online submissions for Island Perimeter.
    //     Memory Usage: 43 MB, less than 89.50% of Java online submissions for Island Perimeter.
    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    
    public boolean isHappy(int n) {
        if (n < 11)
            return n == 1 || n == 7 || n == 10 ? true : false;
        if (memo.get(n) == null) {
            int rem = 0, sum = 0, num = n;
            while (num > 0) {
                rem = num % 10;
                sum += rem * rem;
                num /= 10;
            }
            memo.put(n, sum);
        }
        return isHappy(memo.get(n));
    }
*/

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int h = grid.length, w = grid[0].length;
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                if (grid[r][c] == 1)
                    return recursion(grid, 
                            new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, 
                            r, c, h, w);
        return 0;
    }

    public static int recursion(int[][] g, int[][] d, int r, int c, int h, int w) {
        if (r < 0 || c < 0 || r >= h || c >= w || g[r][c] == 0)
            return 1;
        if (g[r][c] < 0)
            return 0;
        int ans = 0;
        g[r][c] = -1;
        for (int[] dir : d)
            ans += recursion(g, d, r + dir[0], c + dir[1], h, w);
        return ans;
    }

    public static void main(String[] args) {
        // Test code
        int[][] grid = {{1}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
    }
}
