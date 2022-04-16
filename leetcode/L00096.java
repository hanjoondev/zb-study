package leetcode;

import java.math.*;

public class L00096 {
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
