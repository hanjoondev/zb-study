import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L1412 {
    public static void solution(int[][] matrix) {
        List<Integer> row = new ArrayList<>(), col = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (row.contains(i) || col.contains(j))
                    matrix[i][j] = 0;
        System.out.println(IntStream.range(0, matrix.length)
            .mapToObj(i -> String.format("%s", Arrays.toString(matrix[i])))
            .collect(Collectors.joining("\n")));
    }

/* leetcode submission
    // Source: 73. Set Matrix Zeroes https://leetcode.com/problems/set-matrix-zeroes/
    // Submission detail: https://leetcode.com/submissions/detail/676702425/
    //     Runtime: Runtime: 20 ms, faster than 5.10% of Java online submissions for Set Matrix Zeroes.
    //     Memory Usage: 43.8 MB, less than 90.66% of Java online submissions for Set Matrix Zeroes.
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>(), col = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (row.contains(i) || col.contains(j))
                    matrix[i][j] = 0;
    }
*/

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
