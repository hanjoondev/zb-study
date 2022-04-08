public class P1825 {
    public static int solution(int[] ratings) {
        int len = ratings.length;
        int[] fToR = new int[len], rToF = new int[len];
        fToR[0] = 1;
        rToF[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            fToR[i] = ratings[i] > ratings[i - 1] ? fToR[i - 1] + 1 : 1;
            rToF[len - i - 1] = ratings[len - i - 1] > ratings[len - i] ? rToF[len - i] + 1 : 1;
        }
        int ans = 0;
        for (int i = 0; i < len; i++)
            ans += Math.max(fToR[i], rToF[i]);
        return ans;
    }

/* leetcode submission
    // Source: 135. Candy https://leetcode.com/problems/candy/
    // Submission detail: https://leetcode.com/submissions/detail/676509118/
    //     Runtime: 4 ms, faster than 68.10% of Java online submissions for Candy.
    //     Memory Usage: 52 MB, less than 42.08% of Java online submissions for Candy.
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
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings));

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings));
    }
}
