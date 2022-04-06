public class M0922 {
    public static int solution(String str) {
        int len = str.length() - 1, ans = 2;
        char[] s = str.toCharArray();
        for (int i = -1; i <= len; i++)
            ans = Math.min(ans, isPalindrome(0, len, s, i));
        return ans;
    }

    public static int isPalindrome(int l, int r, char[] a, int d) {
        while (l < r) {
            if (l == d) {
                l++;
            } else if (r == d) {
                r--;
            } else {
                if (a[l] != a[r])
                    return 2;
                l++;
                r--;
            }
        }
        return d >= 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        // Test code
        String[] str = {"abba", "summuus", "xabba", "xabbay", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("xabbay"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));
    }
}
