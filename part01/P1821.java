import java.util.HashMap;
import java.util.Map;

public class P1821 {
    public static void solution(String s) {
        Map<String, Integer> d = new HashMap<String, Integer>() {{
            put("I", 1); put("IV", 4); put("V", 5); put("IX", 9);
            put("X", 10); put("XL", 40); put("L", 50); put("XC", 90);
            put("C", 100); put("CD", 400); put("D", 500); put("CM", 900);
            put("M", 1000);
        }};
        String[] doubleCharacters = {"IV", "IX", "XL", "XC", "CD", "CM"};
        String tmp = s;
        int ans = 0;
        for (String dc : doubleCharacters) {
            if (tmp.contains(dc))
                ans += d.get(dc);
            tmp = tmp.replace(dc, "");
        }
        for (int i = 0; i < tmp.length(); i++)
            ans += d.get(String.valueOf(tmp.charAt(i)));
        System.out.println(ans);
    }

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
