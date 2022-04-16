package leetcode;

import java.util.*;
import java.util.stream.*;

public class L00752 {
    public int openLock(String[] deadends, String target) {
        if (Arrays.stream(deadends).anyMatch(s -> s.equals("0000")))
            return -1;
        Queue<Integer> queue = new LinkedList<>() {{ add(0); }};
        HashSet<Integer> visited = new HashSet<>() {{ add(0); }};
        int[] d = Stream.of(deadends).mapToInt(Integer::parseInt).toArray();
        int t = Integer.parseInt(target), counter = 0, qlen = queue.size();
        while (qlen > 0) {
            for (int i = 0; i < qlen; i++) {
                int cur = queue.poll();
                if (cur == t)
                    return counter;
                for (int j = 1; j < 10000; j *= 10) {
                    int f = cur % (j * 10) / j == 9 ? cur - 9 * j : cur + j;
                    int b = cur % (j * 10) / j == 0 ? cur + 9 * j : cur - j;
                    for (int k : new int[] {f, b})
                        if (!visited.contains(k) && !Arrays.stream(d).anyMatch(x -> x == k)) {
                            queue.add(k);
                            visited.add(k);
                        }
                }
            }
            qlen = queue.size();
            counter++;
        }
        return -1;
    }
}
