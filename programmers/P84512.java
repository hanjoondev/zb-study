package programmers;

public class P84512 {
    public int solution(String word) {
        String str = "AEIOU";
        int[] diff = new int[5];
        for (int i = 4; i >= 0; i--)
            diff[i] = diff[i < 4 ? i + 1 : i] * 5 + 1;
        int ans = word.length();
        for (int i = 0; i < word.length(); i++)
            ans += diff[i] * str.indexOf(word.charAt(i));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P84512().solution("AAAAE"));
        System.out.println(new P84512().solution("AAAE"));
        System.out.println(new P84512().solution("I"));
        System.out.println(new P84512().solution("EIO"));
    }
}
