package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class L00049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) return new ArrayList<>() {{ add(Arrays.asList(strs)); }};
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            map.computeIfAbsent(String.valueOf(tmp), x -> new ArrayList<>()).add(i);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<Integer> list : map.values())
            res.add(list.stream().map(i -> strs[i]).collect(Collectors.toList()));
        return res;
    }
}
