import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N1315 {
    public static int solution(int[] forbidden, int a, int b, int x) {
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

/* leetcode submission
    // Source: 1654. Minimum Jumps to Reach Home https://leetcode.com/problems/minimum-jumps-to-reach-home/
    // Submission detail: https://leetcode.com/submissions/detail/679198015/
    //     Runtime: 43 ms, faster than 52.08% of Java online submissions for Minimum Jumps to Reach Home.
    //     Memory Usage: 53.6 MB, less than 69.39% of Java online submissions for Minimum Jumps to Reach Home.
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
*/
    public static void main(String[] args) {
        // Test code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));
    }
}
