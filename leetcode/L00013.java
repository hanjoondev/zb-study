package leetcode;

import java.util.*;

public class L00013 {
    public int romanToInt(String s) {
        HashMap<String, Integer> toInt = new HashMap<>() {{
            put("I", 1); put("V", 5); put("X", 10); put("L", 50);
            put("C", 100); put("D", 500); put("M", 1000);
        }};
        int ans = toInt.get(s.substring(s.length() - 1, s.length()));
        int prev = ans, cur = ans;
        for (int i = s.length() - 2; i >= 0 ; i--) {
            cur = toInt.get(s.substring(i, i + 1));
            ans += cur * (cur < prev ? -1 : 1);
            prev = cur;
        }
        return ans;
    }
}
