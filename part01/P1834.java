import java.util.ArrayList;

public class P1834 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        int h = matrix.length - 1, w = matrix[0].length - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int r = 0, c = 0;
        while (r <= h && c <= w) {
            for (int i = c; i <= w; i++)
                ans.add(matrix[r][i]);
            r++;
            for (int i = r; i <= h; i++)
                ans.add(matrix[i][w]);
            w--;
            if (r <= h)
                for (int i = w; i >= c; i--)
                    ans.add(matrix[h][i]);
            h--;
            if (c <= w)
                for (int i = h; i >= r; i--)
                    ans.add(matrix[i][c]);
            c++;
        }
        return ans;
    }

/* leetcode submission
    // Source: 54. Spiral Matrix https://leetcode.com/problems/spiral-matrix/
    // Submission detail: https://leetcode.com/submissions/detail/678646528/
    //     Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    //     Memory Usage: 42.2 MB, less than 49.20% of Java online submissions for Spiral Matrix.
    public List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length - 1, w = matrix[0].length - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int r = 0, c = 0;
        while (r <= h && c <= w) {
            for (int i = c; i <= w; i++)
                ans.add(matrix[r][i]);
            r++;
            for (int i = r; i <= h; i++)
                ans.add(matrix[i][w]);
            w--;
            if (r <= h)
                for (int i = w; i >= c; i--)
                    ans.add(matrix[h][i]);
            h--;
            if (c <= w)
                for (int i = h; i >= r; i--)
                    ans.add(matrix[i][c]);
            c++;
        }
        return ans;
    }
*/

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10 ,11 ,12}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10 ,11 ,12}, {13 ,14, 15}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{}};
        System.out.println((solution(matrix)));
    }
}
