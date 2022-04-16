package leetcode;

import java.util.*;

public class L00442 {
    public List<Integer> findDuplicates(int[] n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        while (i < n.length) {
            if (n[i] - 1 == i || n[n[i] - 1] == n[i]) {
                i++;
            } else {
                int t = n[i];
                n[i] = n[n[i] - 1];
                n[t - 1] = t;
            }
        }
        for (int j = 0; j < n.length; j++)
            if (n[j] != j + 1)
                ans.add(n[j]);
        return ans;
    }
}
