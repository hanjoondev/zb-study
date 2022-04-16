package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P01878 {
    public int[] solution(int[][] v) {
        HashMap<Integer, Integer> r = new HashMap<>(), c = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            r.put(v[i][0], r.getOrDefault(v[i][0], 0) + 1);
            c.put(v[i][1], c.getOrDefault(v[i][1], 0) + 1);
        }
        return new int[] {Collections.min(r.entrySet(), Map.Entry.comparingByValue()).getKey(), 
            Collections.min(c.entrySet(), Map.Entry.comparingByValue()).getKey()};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P01878().solution(new int[][]{{1, 4}, {3, 4}, {3, 10}})));
        System.out.println(Arrays.toString(new P01878().solution(new int[][]{{1, 1}, {2, 2}, {1, 2}})));
    }
}
