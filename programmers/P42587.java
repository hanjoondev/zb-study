package programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class P42587 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> papers = new LinkedList<Integer>();
        Queue<Integer> marker = new LinkedList<Integer>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < priorities.length; i++) {
            counts.put(priorities[i], counts.getOrDefault(priorities[i], 0) + 1);
            papers.add(priorities[i]);
            marker.add(i == location ? 1 : 0);
        }
        int ans = 1;
        while (true) {
            int p = papers.poll(), t = marker.poll();
            if (p >= Collections.max(counts.keySet())) {
                if (t == 1)
                    return ans;
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
        System.out.println(new P42587().solution(new int[] {2, 1, 3, 2}, 2));
        System.out.println(new P42587().solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }
}
