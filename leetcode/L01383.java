package leetcode;

import java.util.*;
import java.util.stream.*;

public class L01383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) (Math.pow(10, 9) + 7);
        if (n == 1)
            return (speed[0] * efficiency[0]) % mod;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long spd = 0, perf = 0;
        for (int[] es : IntStream.range(0, speed.length)
                                 .mapToObj(i -> new int[] { efficiency[i], speed[i] })
                                 .sorted(Collections.reverseOrder((a, b) -> a[0] - b[0]))
                                 .collect(Collectors.toList())) {
            spd += es[1];
            pq.add(es[1]);
            if (pq.size() > k)
                spd -= pq.poll();
            perf = Math.max(perf, spd * es[0]);
        }
        return (int) (perf % mod);
    }
}
