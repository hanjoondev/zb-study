package leetcode;

public class L00130 {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int r = 0; r < h; r++) {
            if (board[r][0] == 'O')
                dfs(board, r, 0, visited);
            if (board[r][w - 1] == 'O')
                dfs(board, r, w - 1, visited);
        }
        for (int c = 0; c < w; c++) {
            if (board[0][c] == 'O')
                dfs(board, 0, c, visited);
            if (board[h - 1][c] == 'O')
                dfs(board, h - 1, c, visited);
        }
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                if (board[r][c] == 'O' && !visited[r][c])
                    board[r][c] = 'X';
    }
    public static void dfs(char[][] b, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length || b[r][c] != 'O' || visited[r][c])
            return;
        visited[r][c] = true;
        for (int[] d : dir)
            dfs(b, r + d[0], c + d[1], visited);
    }
}
