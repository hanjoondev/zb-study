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
            if (counts.containsKey(p)) {
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

/* programmers submission
    // Source: 프린터 https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
    // Submission detail:
    //     정확성  테스트
    //     테스트 1 〉	통과 (0.41ms, 73.2MB)
    //     테스트 2 〉	통과 (1.29ms, 76.1MB)
    //     테스트 3 〉	통과 (0.36ms, 72.6MB)
    //     테스트 4 〉	통과 (0.29ms, 80.4MB)
    //     테스트 5 〉	통과 (0.22ms, 77.8MB)
    //     테스트 6 〉	통과 (0.58ms, 75.5MB)
    //     테스트 7 〉	통과 (0.53ms, 76.6MB)
    //     테스트 8 〉	통과 (1.02ms, 74.1MB)
    //     테스트 9 〉	통과 (0.28ms, 75MB)
    //     테스트 10 〉	통과 (0.58ms, 72.8MB)
    //     테스트 11 〉	통과 (0.98ms, 76.7MB)
    //     테스트 12 〉	통과 (0.29ms, 65.7MB)
    //     테스트 13 〉	통과 (0.96ms, 75MB)
    //     테스트 14 〉	통과 (0.12ms, 73.3MB)
    //     테스트 15 〉	통과 (0.31ms, 81.3MB)
    //     테스트 16 〉	통과 (0.43ms, 76.9MB)
    //     테스트 17 〉	통과 (1.65ms, 75.6MB)
    //     테스트 18 〉	통과 (0.29ms, 75.1MB)
    //     테스트 19 〉	통과 (0.97ms, 76MB)
    //     테스트 20 〉	통과 (0.53ms, 83.3MB)
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> papers = new LinkedList<Integer>();
        Queue<Integer> marker = new LinkedList<Integer>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < priorities.length; i++) {
            int p = priorities[i];
            if (counts.containsKey(p)) {
                int tmp = counts.get(p);
                counts.put(p, ++tmp);
            } else {
                counts.put(p, 1);
            }
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
}
*/
