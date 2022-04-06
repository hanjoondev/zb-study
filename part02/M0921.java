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


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
