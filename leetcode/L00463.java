package leetcode;

public class L00463 {
    public int islandPerimeter(int[][] grid) {
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
}
