import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class N1314 {
    public static int solution(String[] deadends, String target) {
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

/* leetcode submission
    // Source: 752. Open the Lock https://leetcode.com/problems/open-the-lock/
    // Submission detail: https://leetcode.com/submissions/detail/678993164/
    //     Runtime: 619 ms, faster than 6.40% of Java online submissions for Open the Lock.
    //     Memory Usage: 44.6 MB, less than 97.02% of Java online submissions for Open the Lock.
    // TODO: improve performance of this method
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
*/

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[] {"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}


/*
queue = [0]
visited = {0}
steps = 0
deadends_int = [int(x) for x in deadends]

if 0 in deadends_int:
    return -1

# BFS (Breadth-first Search) Algorithm:
while queue:
    lenght = len(queue)
    for i in range(lenght):
        if queue[i] == int(target):
            return steps
        else:
            for n in (1, 10, 100, 1000):
                # Check if there is digit 9 in number
                if queue[i]%(n*10)//n == 9:
                    forward = queue[i]-9*n
                    backward = queue[i]-n
                # Check if there is digit 0 in number
                elif queue[i]%(n*10)//n == 0:
                    forward = queue[i]+n
                    backward = queue[i]+9*n
                else:
                    forward = queue[i]+n
                    backward = queue[i]-n

                for element in (forward, backward):
                    if element not in visited and element not in deadends_int:
                        queue.append(element)
                        visited.add(element)
    queue = queue[lenght:]
    steps += 1
return -1
*/
