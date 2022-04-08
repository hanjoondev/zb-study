public class P1811 {
    public static int solution(int n) {
        return n < 0 ? -solution(-n) : Integer.parseInt(new StringBuilder().append(n).reverse().toString());
    }

/* leetcode submission
    // Source: 7. Reverse Integer https://leetcode.com/problems/reverse-integer/
    // Submission detail: https://leetcode.com/submissions/detail/676433438/
    //     Runtime: 1 ms, faster than 98.90% of Java online submissions for Reverse Integer.
    //     Memory Usage: 39.8 MB, less than 84.49 % of Java online submissions for Reverse Integer.
    public int reverse(int x) {
        Boolean neg = x < 0;
        x = neg ? -x : x;
        String ans = new StringBuilder().append(x).reverse().toString();
        try {
            return Integer.parseInt(ans) * (neg ? -1 : 1);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
*/

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(12345));
        System.out.println(solution(-12345));
        System.out.println(solution(100));
        System.out.println(solution(0));
    }
}
