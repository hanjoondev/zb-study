package leetcode;

public class L00007 {
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
}
