package leetcode;

public class L00073 {
    public void setZeroes(int[][] matrix) {
        Boolean firstRow = false, firstCol = false;
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                if (matrix[r][c] == 0) {
                    if (r == 0) firstRow = true;
                    if (c == 0) firstCol = true;
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
        for (int r = 1; r < matrix.length; r++)            
            for (int c = 1; c < matrix[0].length; c++)
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                    matrix[r][c] = 0;
        if (firstRow) matrix[0] = new int[matrix[0].length];
        if (firstCol)
            for (int r = 0; r < matrix.length; r++)
                matrix[r][0] = 0;
    }
}
