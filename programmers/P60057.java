package programmers;

public class P60057 {
    public int solution(String s) {
        int ans = s.length(), slen = s.length();
        for (int div = slen / 2; div > 0; div--) {
            int q = slen / div, r = slen % div, len = 0, matched = 1;
            String prev = s.substring(0, div);
            for (int i = div; i < div * q; i += div) {
                String cur = s.substring(i, i + div);
                if (prev.equals(cur)) {
                    matched++;
                } else {
                    len += matched > 1 ? String.valueOf(matched).length() + div : div;
                    matched = 1;
                }
                prev = cur;
            }
            len += matched > 1 ? String.valueOf(matched).length() + div + r : div + r;
            ans = len < ans ? len : ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P60057().solution("aabbaccc"));
        System.out.println(new P60057().solution("ababcdcdababcdcd"));
        System.out.println(new P60057().solution("abcabcdede"));
        System.out.println(new P60057().solution("abcabcabcabcdededededede"));
        System.out.println(new P60057().solution("xababcdcdababcdcd"));
    }
}
