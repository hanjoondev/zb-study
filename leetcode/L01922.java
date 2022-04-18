package leetcode;

public class L01922 {
    public int countGoodNumbers(long n) {
        int mod = 1_000_000_007;
        long ans = n % 2 == 0 ? 1 : 5;
        long x = 20;
        for (long i = n / 2; i > 0; i /= 2) {
            if (i % 2 > 0) {
                ans *= x;
                ans %= mod;
            }
            x *= x;
            x %= mod;
        }
        return (int) ans;
    }
}
