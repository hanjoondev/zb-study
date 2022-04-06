import java.util.HashMap;

public class M0914 {
    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public static boolean solution(int n) {
        if (n < 11)
            return n == 1 || n == 7 || n == 10 ? true : false;
        if (memo.get(n) == null) {
            int rem = 0, sum = 0, num = n;
            while (num > 0) {
                rem = num % 10;
                sum += rem * rem;
                num /= 10;
            }
            memo.put(n, sum);
        }
        return solution(memo.get(n));
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
        System.out.println(solution(97));
        System.out.println(solution(818));
    }
}
