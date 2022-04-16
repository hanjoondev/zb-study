package leetcode;

import java.util.*;

public class L00054 {
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
}
