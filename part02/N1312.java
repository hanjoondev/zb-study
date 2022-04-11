public class N1312 {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void solution(char[][] board) {
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

/* leetcode submission
    // Source: 130. Surrounded Regions https://leetcode.com/problems/surrounded-regions/
    // Submission detail: https://leetcode.com/submissions/detail/678250592/
    //     Runtime: 2 ms, faster than 79.16% of Java online submissions for Surrounded Regions.
    //     Memory Usage: 51.6 MB, less than 53.58% of Java online submissions for Surrounded Regions.
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
*/

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
