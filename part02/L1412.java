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

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
