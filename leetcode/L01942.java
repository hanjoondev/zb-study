package leetcode;

import java.util.*;

public class L01942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0], heapSize = times.length;
        PriorityQueue<int[]> chairs = new PriorityQueue<>( (x, y) -> x[0] - y[0] );
        PriorityQueue<Integer> empty = new PriorityQueue<>();
        Arrays.sort(times, (x, y) -> x[0] - y[0]);
        for (int i = 0; i < heapSize; i++) {
            while (!chairs.isEmpty() && times[i][0] >= chairs.peek()[0])
                empty.offer(chairs.poll()[1]);
            if (times[i][0] == targetArrival)
                return empty.isEmpty() ? chairs.size() : empty.poll();
            chairs.offer(new int[] { times[i][1], empty.isEmpty() ? chairs.size() : empty.poll() });
        }
        return -1;
    }
}
