import java.util.ArrayList;

public class M0911 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(row);
        }
        return ans;
    }

/* leetcode submission
    // Source: 118. Pascal's Triangle https://leetcode.com/problems/pascals-triangle/
    // Submission detail: https://leetcode.com/submissions/detail/676638672/
    //     Runtime: 1 ms, faster than 64.28% of Java online submissions for Pascal's Triangle.
    //     Memory Usage: 41.8 MB, less than 61.44% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(row);
        }
        return ans;
    }
}
*/

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
