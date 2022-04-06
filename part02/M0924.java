import java.math.BigInteger;

public class M0924 {
    public static int solution(long n) {
        BigInteger mod = new BigInteger("1000000007");
        BigInteger b5 = new BigInteger("5"), b4 = new BigInteger("4");
        BigInteger ans = b5.modPow(new BigInteger(String.valueOf(n % 2 == 0 ? n / 2 : (n + 1) / 2)), mod)
               .multiply(b4.modPow(new BigInteger(String.valueOf(n % 2 == 0 ? n / 2 : (n - 1) / 2)), mod));
        return ans.mod(mod).intValue();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));
    }
}
