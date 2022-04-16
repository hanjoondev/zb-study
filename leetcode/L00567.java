package leetcode;

import java.util.*;

public class L00567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String target = new String(c1);
        for (int i = 0; i < s2.length() - c1.length + 1; i++) {
            char[] tmp = s2.substring(i, c1.length + i).toCharArray();
            Arrays.sort(tmp);
            String sub = new String(tmp);
            if (sub.equals(target))
                return true;
        }
        return false;
    }
}
