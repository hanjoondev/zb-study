package leetcode;

public class L00012 {
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
}
