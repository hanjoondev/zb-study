import java.util.HashMap;

public class P1821 {
    public static void solution(String s) {
        HashMap<String, Integer> toInt = new HashMap<>() {{
            put("I", 1); put("V", 5); put("X", 10); put("L", 50);
            put("C", 100); put("D", 500); put("M", 1000);
        }};
        int ans = toInt.get(s.substring(s.length() - 1, s.length()));
        int prev = ans, cur = ans;
        for (int i = s.length() - 2; i >= 0 ; i--) {
            cur = toInt.get(s.substring(i, i + 1));
            ans += cur * (cur < prev ? -1 : 1);
            prev = cur;
        }
        System.out.println(ans);
    }

/* leetcode submission
    // Source: 13. Roman to Integer https://leetcode.com/problems/roman-to-integer/
    // Submission detail: https://leetcode.com/submissions/detail/678578888/
    //     Runtime: 4 ms, faster than 93.65% of Java online submissions for Roman to Integer.
    //     Memory Usage: 42.7 MB, less than 87.18% of Java online submissions for Roman to Integer.
    public int romanToInt(String s) {
        HashMap<String, Integer> toInt = new HashMap<>() {{
            put("I", 1); put("V", 5); put("X", 10); put("L", 50);
            put("C", 100); put("D", 500); put("M", 1000);
        }};
        int ans = toInt.get(s.substring(s.length() - 1, s.length()));
        int prev = ans, cur = ans;
        for (int i = s.length() - 2; i >= 0 ; i--) {
            cur = toInt.get(s.substring(i, i + 1));
            ans += cur * (cur < prev ? -1 : 1);
            prev = cur;
        }
        return ans;
    }
*/

    public static void main(String[] args) {
        // Test code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
    }
}
