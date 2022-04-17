package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P67258 {
    public static void addSub(String add, String sub, HashMap<String, Integer> count) {
        if (add != null)
            count.put(add, count.getOrDefault(add, 0) + 1);
        if (sub != null) {
            int tmp = count.get(sub);
            if (tmp > 1)
                count.put(sub, tmp - 1);
            else
                count.remove(sub);
        }
    }

    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(gems));
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        addSub(gems[0], null, count);
        int numTypes = set.size(), last = gems.length;
        int l = 0, r = 0, sl = 1, sr = last;
        while (l <= r && r < last) {
            if (count.size() == numTypes) {
                if (r - l < sr - sl) {
                    sl = l + 1;
                    sr = r + 1;
                }
                addSub(null, gems[l], count);
                l++;
                continue;
            }
            r++;
            if (r < last)
                addSub(gems[r], null, count);
        }
        return new int[] {sl, sr};
    }
    

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P67258().solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(new P67258().solution(new String[] {"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(new P67258().solution(new String[] {"XYZ", "XYZ", "XYZ"})));
        System.out.println(Arrays.toString(new P67258().solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
    }
}
