package leetcode;

import java.util.*;

public class L01354 {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long total = 0, biggest = 0, rest = 0;
        for (int n : target) {
            pq.add((long) -n);
            total += n;
        }
        while (true) {
            biggest = -pq.poll();
            rest = total - biggest;
            if (biggest == 1)
                return true;
            if (biggest <= rest || rest == 0)
                return false;
            long tmp = biggest % rest;
            biggest = tmp != 0 ? tmp : rest;
            total = biggest % rest + rest;
            pq.add(-biggest);
        }
    }
}
