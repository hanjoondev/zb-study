import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L1421 {
    public static void solution(int docs, int target, int[] priorities) {
        Queue<Integer> papers = new LinkedList<Integer>();
        Queue<Integer> marker = new LinkedList<Integer>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < docs; i++) {
            int p = priorities[i];
            if (counts.containsValue(p)) {
                int tmp = counts.get(p);
                counts.put(p, ++tmp);
            } else {
                counts.put(p, 1);
            }
            papers.add(priorities[i]);
            marker.add(i == target ? 1 : 0);
        }
        int ans = 1;
        while (true) {
            int p = papers.poll(), t = marker.poll();
            if (p >= Collections.max(counts.keySet())) {
                if (t == 1) {
                    System.out.println(ans);
                    return;
                }
                ans++;
                int tmp = counts.get(p);
                if (tmp > 1)
                    counts.put(p, --tmp);
                else
                    counts.remove(p);

            } else {
                papers.add(p);
                marker.add(t);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs, target, priority);

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);
    }
}
