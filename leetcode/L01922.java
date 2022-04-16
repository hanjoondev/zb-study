package leetcode;

import java.math.*;

public class L01922 {
    public int countGoodNumbers(long n) {
        BigInteger mod = new BigInteger("1000000007");
        BigInteger b5 = new BigInteger("5"), b4 = new BigInteger("4");
        BigInteger ans = b5.modPow(new BigInteger(String.valueOf(n % 2 == 0 ? n / 2 : (n + 1) / 2)), mod)
               .multiply(b4.modPow(new BigInteger(String.valueOf(n % 2 == 0 ? n / 2 : (n - 1) / 2)), mod));
        return ans.mod(mod).intValue();
    }
}
