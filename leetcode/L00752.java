package leetcode;

import java.util.*;

public class L00752 {
    public int openLock(String[] deadends, String target) {
        boolean[] visited = new boolean[10000];
        for (String deadend : deadends) {
            if (deadend.equals(target))
                return -1;
            visited[Integer.parseInt(deadend)] = true;
        }
        if (visited[0])
            return -1;
        int t = Integer.parseInt(target), counter = 0, qlen;
        if (t == 0)
            return 0;
        Queue<Integer> queue = new LinkedList<>() {{ add(0); }};
        queue.add(0);
        counter++;
        while (!queue.isEmpty()) {
            qlen = queue.size();
            for (int i = 0; i < qlen; i++) {
                int cur = queue.poll();
                for (int j = 1; j < 10000; j *= 10) {
                    int tDigit = (cur / j) % 10;
                    int base = cur - tDigit * j;
                    int u = base + (tDigit + 1) % 10 * j;
                    int d = base + (tDigit + 9) % 10 * j;
                    if (u == t || d == t)
                        return counter;
                    if (!visited[u]) {
                        visited[u] = true;
                        queue.offer(u);
                    }
                    if (!visited[d]) {
                        visited[d] = true;
                        queue.offer(d);
                    }
                }
            }
            counter++;
        }
        return -1;
    }
}
