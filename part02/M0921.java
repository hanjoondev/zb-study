import java.math.BigInteger;

public class M0921 {
    public static int solution(int n) {
        BigInteger fact2n = new BigInteger("1"), factSquared = new BigInteger("1");
        for (int i = 2 * n; i > 1; i--)
            fact2n = fact2n.multiply(BigInteger.valueOf(i));
        for (int i = n; i > 1; i--)
            factSquared = factSquared.multiply(BigInteger.valueOf(i));
        factSquared = factSquared.multiply(factSquared);
        return fact2n.divide(factSquared).divide(BigInteger.valueOf(n + 1)).intValue();
    }

/* leetcode submission
    // Source: 96. Unique Binary Search Trees https://leetcode.com/problems/unique-binary-search-trees/
    // Submission detail: https://leetcode.com/submissions/detail/676696655/
    //     Runtime: 1 ms, faster than 16.24% of Java online submissions for Unique Binary Search Trees.
    //     Memory Usage: 39.3 MB, less than 80.44% of Java online submissions for Unique Binary Search Trees.
import java.math.BigInteger;

class Solution {
    public int numTrees(int n) {
        BigInteger fact2n = new BigInteger("1"), factSquared = new BigInteger("1");
        for (int i = 2 * n; i > 1; i--)
            fact2n = fact2n.multiply(BigInteger.valueOf(i));
        for (int i = n; i > 1; i--)
            factSquared = factSquared.multiply(BigInteger.valueOf(i));
        factSquared = factSquared.multiply(factSquared);
        return fact2n.divide(factSquared).divide(BigInteger.valueOf(n + 1)).intValue();
    }
}
*/

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
