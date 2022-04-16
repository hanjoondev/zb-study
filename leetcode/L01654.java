package leetcode;

import java.util.*;
import java.util.stream.*;

public class L01654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> visited = IntStream.of(forbidden).boxed().collect(Collectors.toCollection(HashSet::new));
        Queue<Integer> queue = new LinkedList<>() {{ add(0);}};
        Queue<Integer> squeue = new LinkedList<>() {{ add(0); }};
        Queue<Boolean> bqueue = new LinkedList<>() {{ add(false);}};
        int limit = Math.max(x, Arrays.stream(forbidden).max().getAsInt()) + a + b;  
        while (queue.size() > 0) {
            int pos = queue.poll(), steps = squeue.poll();
            Boolean backstepped = bqueue.poll();
            if (pos == x)
                return steps;
            if (!visited.contains(pos - b) && !backstepped && pos - b > 0) {
                queue.add(pos - b);
                squeue.add(steps + 1);
                bqueue.add(true);
                visited.add(pos - b);
            }
            if (!visited.contains(pos + a) && pos + a <= limit) {
                queue.add(pos + a);
                squeue.add(steps + 1);
                bqueue.add(false);
                visited.add(pos + a);
            }
        }
        return -1;
    }
}
