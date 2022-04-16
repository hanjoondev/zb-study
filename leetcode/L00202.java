package leetcode;

import java.util.*;

public class L00202 {
    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    
    public boolean isHappy(int n) {
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
        return isHappy(memo.get(n));
    }
}
