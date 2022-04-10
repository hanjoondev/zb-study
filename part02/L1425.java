import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

public class L1425 {
    public static void addSub(String add, String sub, HashMap<String, Integer> count) {
        if (add != null)
            count.put(add, count.getOrDefault(add, 0) + 1);
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
    //     테스트 1 〉	통과 (0.16ms, 84.1MB)
    //     테스트 2 〉	통과 (0.26ms, 73.6MB)
    //     테스트 3 〉	통과 (0.61ms, 78.6MB)
    //     테스트 4 〉	통과 (0.53ms, 75.6MB)
    //     테스트 5 〉	통과 (0.20ms, 76.6MB)
    //     테스트 6 〉	통과 (0.17ms, 76.1MB)
    //     테스트 7 〉	통과 (0.15ms, 73MB)
    //     테스트 8 〉	통과 (0.87ms, 69.2MB)
    //     테스트 9 〉	통과 (0.97ms, 87.1MB)
    //     테스트 10 〉	통과 (0.97ms, 76.8MB)
    //     테스트 11 〉	통과 (0.92ms, 76.3MB)
    //     테스트 12 〉	통과 (1.47ms, 87.4MB)
    //     테스트 13 〉	통과 (1.52ms, 78.5MB)
    //     테스트 14 〉	통과 (1.48ms, 82.5MB)
    //     테스트 15 〉	통과 (2.17ms, 80.3MB)
    //     효율성  테스트
    //     테스트 1 〉	통과 (6.90ms, 55.2MB)
    //     테스트 2 〉	통과 (7.13ms, 56.9MB)
    //     테스트 3 〉	통과 (14.31ms, 58.4MB)
    //     테스트 4 〉	통과 (10.00ms, 60.1MB)
    //     테스트 5 〉	통과 (16.16ms, 62.3MB)
    //     테스트 6 〉	통과 (17.59ms, 64.6MB)
    //     테스트 7 〉	통과 (26.76ms, 64.5MB)
    //     테스트 8 〉	통과 (24.75ms, 67.6MB)
    //     테스트 9 〉	통과 (35.58ms, 70.4MB)
    //     테스트 10 〉	통과 (35.93ms, 74.7MB)
    //     테스트 11 〉	통과 (49.58ms, 79.2MB)
    //     테스트 12 〉	통과 (43.07ms, 80MB)
    //     테스트 13 〉	통과 (61.16ms, 79.9MB)
    //     테스트 14 〉	통과 (52.36ms, 97.8MB)
    //     테스트 15 〉	통과 (60.42ms, 81.2MB)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void addSub(String add, String sub, HashMap<String, Integer> count) {
        if (add != null)
            count.put(add, count.getOrDefault(add, 0) + 1);
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
