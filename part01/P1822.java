public class P1822 {
    public static String solution(int num){
        String result = "", d = "IVXLCDM";
        for (int i = 1; i < 6; i += 2) {
            int q = num % 10 / 5;
            int r = num % 10 % 5;
            num /= 10;
            if (r < 4)
                result += String.valueOf(d.charAt(i - 1)).repeat(r) + String.valueOf(d.charAt(i)).repeat(q);
            else
                result += String.valueOf(d.charAt(i + q)) + String.valueOf(d.charAt(i - 1));
        }
        result += String.valueOf(d.charAt(d.length() - 1)).repeat(num);
        return new StringBuilder(result).reverse().toString();
    }

/* leetcode submission
    // Source: 12. Integer to Roman https://leetcode.com/problems/integer-to-roman/
    // Submission detail: https://leetcode.com/submissions/detail/676445203/
    //     Runtime: 24 ms, faster than 13.34% of Java online submissions for Integer to Roman.
    //     Memory Usage: 47.6 MB, less than 16.81% of Java online submissions for Integer to Roman.
    public int romanToInt(String s) {
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
        return ans;
    }
*/

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(13));
        System.out.println(solution(26));
        System.out.println(solution(1994));
    }
}
