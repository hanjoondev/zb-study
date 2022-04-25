package leetcode;

import java.util.*;

public class L01023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        int plen = pattern.length();
        for (String query : queries) {
            int p = 0, q = 0, qlen = query.length();
            for (; q < qlen; q++) {
                char c = query.charAt(q);
                if ((p == plen || c != pattern.charAt(p)) && c >= 'A' && c <= 'Z')
                    break;
                if (p < plen && c == pattern.charAt(p))
                    p++;
            }
            ans.add(q == qlen && p == plen ? true : false);
        }
        return ans;
    }
}
