public class P1822 {
    public static String solution(int n){
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ans="";
        int i = 0;
        while (n > 0 && i < 13) {
            while (n >= value[i]) {
                ans += roman[i];
                n -= value[i];
            }
            i++;
        }
        return ans;
    }

/* leetcode submission
    // Source: 12. Integer to Roman https://leetcode.com/problems/integer-to-roman/
    // Submission detail: https://leetcode.com/submissions/detail/678587046/
    //     Runtime: 4 ms, faster than 93.10% of Java online submissions for Integer to Roman.
    //     Memory Usage: 42.2 MB, less than 87.75% of Java online submissions for Integer to Roman.
    public String intToRoman(int n) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ans="";
        int i = 0;
        while (n > 0 && i < 13) {
            while (n >= value[i]) {
                ans += roman[i];
                n -= value[i];
            }
            i++;
        }
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
