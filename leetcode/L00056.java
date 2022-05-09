package leetcode;

import java.util.Arrays;
import java.util.ArrayDeque;

public class L00056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (dq.getLast()[1] < intervals[i][0]) {
                dq.add(intervals[i]);
            } else {
                int[] tmp = dq.pollLast();
                tmp[0] = tmp[0] < intervals[i][0] ? tmp[0] : intervals[i][0];
                tmp[1] = tmp[1] > intervals[i][1] ? tmp[1] : intervals[i][1];
                dq.add(tmp);
            }
        }
        int[][] res = new int[dq.size()][2];
        int i = 0;
        while (!dq.isEmpty()) res[i++] = dq.poll();
        return res;
    }
}
