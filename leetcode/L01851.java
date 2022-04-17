package leetcode;

import java.util.*;
import java.util.stream.*;

public class L01851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];
        int[][] qd = IntStream.range(0, queries.length)
                .mapToObj(i -> new int[]{queries[i], i})
                .toArray(int[][]::new);
        int heapSize = intervals.length, i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x, y) -> (x[1] - x[0]) - (y[1] - y[0]));
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        Arrays.sort(qd, (x, y) -> x[0] - y[0]);
        for (int[] q : qd) {
            while (i < heapSize && intervals[i][0] <= q[0])
                pq.offer(intervals[i++]);
            while (!pq.isEmpty() && pq.peek()[1] < q[0])
                pq.poll();
            ans[q[1]] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }
        return ans;
    }
}