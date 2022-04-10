import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

public class L1425 {
    public static void addSub(String add, String sub, HashMap<String, Integer> count) {
        if (add != null) {
            if (count.containsKey(add)) {
                int tmp = count.get(add);
                count.put(add, tmp + 1);
            } else {
                count.put(add, 1);
            }
        }
        if (sub != null) {
            int tmp = count.get(sub);
            if (tmp > 1)
                count.put(sub, tmp - 1);
            else
                count.remove(sub);
        }
    }

    public static ArrayList<Integer> solution(String[] gems) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(gems));
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        addSub(gems[0], null, count);
        int numTypes = set.size(), last = gems.length;
        int l = 0, r = 0, sl = 1, sr = last;
        while (l <= r && r < last) {
            if (count.size() == numTypes) {
                if (r - l < sr - sl) {
                    sl = l + 1;
                    sr = r + 1;
                }
                addSub(null, gems[l], count);
                l++;
                continue;
            }
            r++;
            if (r < last)
                addSub(gems[r], null, count);
        }
        return IntStream.of(sl, sr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void main(String[] args) {
        // Test code
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));
    }
}

/* programmers submission
    // Source: [카카오 인턴] 보석 쇼핑 https://programmers.co.kr/learn/courses/30/lessons/67258
    // Submission detail:
    //     정확성  테스트
    //     테스트 1 〉	통과 (0.13ms, 83.9MB)
    //     테스트 2 〉	통과 (0.32ms, 74.4MB)
    //     테스트 3 〉	통과 (0.41ms, 82MB)
    //     테스트 4 〉	통과 (0.49ms, 87MB)
    //     테스트 5 〉	통과 (0.34ms, 77.3MB)
    //     테스트 6 〉	통과 (0.17ms, 84.3MB)
    //     테스트 7 〉	통과 (0.19ms, 77.8MB)
    //     테스트 8 〉	통과 (0.79ms, 78.4MB)
    //     테스트 9 〉	통과 (1.26ms, 77MB)
    //     테스트 10 〉	통과 (0.79ms, 79.2MB)
    //     테스트 11 〉	통과 (1.33ms, 77.4MB)
    //     테스트 12 〉	통과 (1.58ms, 79.7MB)
    //     테스트 13 〉	통과 (2.27ms, 80.9MB)
    //     테스트 14 〉	통과 (2.18ms, 79.2MB)
    //     테스트 15 〉	통과 (3.37ms, 79MB)
    //     효율성  테스트
    //     테스트 1 〉	통과 (9.86ms, 54.2MB)
    //     테스트 2 〉	통과 (10.12ms, 56.2MB)
    //     테스트 3 〉	통과 (9.90ms, 59.5MB)
    //     테스트 4 〉	통과 (12.16ms, 60.5MB)
    //     테스트 5 〉	통과 (17.55ms, 61.7MB)
    //     테스트 6 〉	통과 (20.22ms, 63.1MB)
    //     테스트 7 〉	통과 (29.46ms, 66.7MB)
    //     테스트 8 〉	통과 (26.65ms, 68.1MB)
    //     테스트 9 〉	통과 (34.55ms, 70.3MB)
    //     테스트 10 〉	통과 (34.46ms, 74.6MB)
    //     테스트 11 〉	통과 (51.62ms, 79.6MB)
    //     테스트 12 〉	통과 (38.43ms, 81.5MB)
    //     테스트 13 〉	통과 (67.20ms, 79.7MB)
    //     테스트 14 〉	통과 (53.34ms, 80.7MB)
    //     테스트 15 〉	통과 (67.83ms, 82.4MB)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void addSub(String add, String sub, HashMap<String, Integer> count) {
        if (add != null) {
            if (count.containsKey(add)) {
                int tmp = count.get(add);
                count.put(add, tmp + 1);
            } else {
                count.put(add, 1);
            }
        }
        if (sub != null) {
            int tmp = count.get(sub);
            if (tmp > 1)
                count.put(sub, tmp - 1);
            else
                count.remove(sub);
        }
    }

    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(gems));
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        addSub(gems[0], null, count);
        int numTypes = set.size(), last = gems.length;
        int l = 0, r = 0, sl = 1, sr = last;
        while (l <= r && r < last) {
            if (count.size() == numTypes) {
                if (r - l < sr - sl) {
                    sl = l + 1;
                    sr = r + 1;
                }
                addSub(null, gems[l], count);
                l++;
                continue;
            }
            r++;
            if (r < last)
                addSub(gems[r], null, count);
        }
        return new int[] {sl, sr};
    }
}
*/
