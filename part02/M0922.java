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

/* acmicpc submission
    // Source: 17609. 회문 https://www.acmicpc.net/problem/17609
    // Submission detail: https://www.acmicpc.net/source/41756976
    //     Runtime: 332 ms
    //     Memory Usage: 34424 KB
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            String s = br.readLine();
            char[] c = s.toCharArray();
            int ans = 0, l = 0, r = c.length - 1;
            while (l < r && ans == 0) {
                if (c[l] != c[r]) {
                    ans = 2;
                    if (c[l + 1] == c[r])
                        ans = Math.min(ans, checker(l + 1, r, c));
                    if (c[l] == c[r - 1])
                        ans = Math.min(ans, checker(l, r - 1, c));
                } else {
                    l++;
                    r--;
                }
            }
            System.out.println(ans);
        }
    }

    public static int checker(int l, int r, char[] c) {
        while (l < r) {
            if (c[l] != c[r])
                return 2;
            l++;
            r--;
        }
        return 1;
    }
}
*/
