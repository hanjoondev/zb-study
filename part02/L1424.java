import java.util.Arrays;

public class L1424 {
    public static String solution(String[] p, String[] c) {
        Arrays.sort(p);
        Arrays.sort(c);
        int i = 0, len = c.length;
        for (; i < len; i++)
            if (!p[i].equals(c[i]))
                return p[i];
        return p[i];
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}

/* programmers submission
    // Source: 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576
    // Submission detail:
    //     정확성 테스트
    //     테스트 1 〉 통과 (0.19ms, 78.8MB)
    //     테스트 2 〉 통과 (0.21ms, 75.7MB)
    //     테스트 3 〉 통과 (1.74ms, 77.8MB)
    //     테스트 4 〉 통과 (2.56ms, 84.6MB)
    //     테스트 5 〉 통과 (2.53ms, 74.2MB)
    //     효율성 테스트
    //     테스트 1 〉 통과 (151.84ms, 81.4MB)
    //     테스트 2 〉 통과 (290.11ms, 89.3MB)
    //     테스트 3 〉 통과 (274.72ms, 93.8MB)
    //     테스트 4 〉 통과 (314.78ms, 95.3MB)
    //     테스트 5 〉 통과 (245.42ms, 95.7MB)
import java.util.Arrays;

class Solution {
    public String solution(String[] p, String[] c) {
        Arrays.sort(p);
        Arrays.sort(c);
        int i = 0, len = c.length;
        for (; i < len; i++)
            if (!p[i].equals(c[i]))
                return p[i];
        return p[i];
    }
}
*/
