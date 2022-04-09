import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


public class M0913 {
    // # 1 기본 permutation 방법
    public static boolean solution1(String s1, String s2) {
        int len = s1.length();
        boolean[] v = new boolean[len];
        char[] o = new char[len];
        ArrayList<String> l = new ArrayList<>();
        permutation(s1.toCharArray(), 0, len, len, v, o, l);
        
        return IntStream.range(0, l.size()).anyMatch(i -> s2.contains(l.get(i)));
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {
        if (depth == r) {
            list.add(new String(out));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    // # 2 문제 규칙 찾아 해결
    public static boolean solution2(String s1, String s2) {  // sorted brute force
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String target = new String(c1);
        for (int i = 0; i < s2.length() - c1.length + 1; i++) {
            char[] tmp = s2.substring(i, c1.length + i).toCharArray();
            Arrays.sort(tmp);
            String sub = new String(tmp);
            if (sub.equals(target))
                return true;
        }
        return false;
    }

/* leetcode submission
    // Source: 567. Permutation in String https://leetcode.com/problems/permutation-in-string/
    // Submission detail: https://leetcode.com/submissions/detail/676693908/
    //     Runtime: 805 ms, faster than 9.33% of Java online submissions for Permutation in String.
    //     Memory Usage: 43 MB, less than 70.40% of Java online submissions for Permutation in String.
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String target = new String(c1);
        for (int i = 0; i < s2.length() - c1.length + 1; i++) {
            char[] tmp = s2.substring(i, c1.length + i).toCharArray();
            Arrays.sort(tmp);
            String sub = new String(tmp);
            if (sub.equals(target))
                return true;
        }
        return false;
    }
*/

    public static boolean solution3(String s1, String s2) {  // sorted brute force
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        for (int i = 0; i < c2.length - c1.length + 1; i++) {
            char[] t = new char[c1.length];
            for (int j = i; j < c1.length + i; j++)
                t[j - i] = c2[j];
            Arrays.sort(t);
            Boolean equal = true;
            for (int j = 0; j < c1.length; j++)
                if (t[j] != c1[j]) {
                    equal = false;
                    break;
                }
            if (equal)
                return true;
            }
        return false;
    }

    public static boolean solution4(String s1, String s2) {  // sorted brute force
        if (s1.length() > s2.length())
            return false;
        int[] abcCount1 = new int[26], abcCount2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            abcCount1[s1.charAt(i) - 'a']++;
            abcCount2[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++)
            if (abcCount1[i] == abcCount2[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26)
                return true;
            int l = s2.charAt(i) - 'a', r = s2.charAt(i + s1.length()) - 'a';
            abcCount2[r]++;
            if (abcCount2[r] == abcCount1[r])
                count++;
            else if (abcCount2[r] == abcCount1[r] + 1)
                count--;
            abcCount2[l]--;
            if (abcCount2[l] == abcCount1[l])
                count++;
            else if (abcCount2[l] == abcCount1[l] - 1)
                count--;
        }
        return count == 26;
    }

    public static void tester(String s1, String s2, int iterations) {
        long start = 0, end = 0, total = 0;

        System.out.printf("\ns1: %s, s2: %s\n", s1, s2);
        for (int i = 0; i < iterations; i++) {
            start = System.nanoTime();
            solution1(s1, s2);
            end = System.nanoTime();
            total += end - start;
        }
        System.out.printf("solution1(s1, s2) returned %s %d times in %sms\n", solution1(s1, s2), iterations, 
                        new DecimalFormat("#,###.00").format((double) total / 1000000));

        total = 0;
        for (int i = 0; i < iterations; i++) {
            start = System.nanoTime();
            solution2(s1, s2);
            end = System.nanoTime();
            total += end - start;
        }
        System.out.printf("solution2(s1, s2) returned %s %d times in %sms\n", solution2(s1, s2), iterations, 
                        new DecimalFormat("#,###.00").format((double) total / 1000000));

        total = 0;
        for (int i = 0; i < iterations; i++) {
            start = System.nanoTime();
            solution3(s1, s2);
            end = System.nanoTime();
            total += end - start;
        }
        System.out.printf("solution3(s1, s2) returned %s %d times in %sms\n", solution3(s1, s2), iterations, 
                        new DecimalFormat("#,###.00").format((double) total / 1000000));
    }

    public static void main(String[] args) {
        // Test code
        String s1 = "ab";
        String s2 = "adbak";
        tester(s1, s2, 10000);

        s1 = "ac";
        s2 = "car";
        tester(s1, s2, 10000);

        s1 = "ak";
        s2 = "aabbkk";
        tester(s1, s2, 10000);

        s1 = "therano";
        s2 = "another level";
        tester(s1, s2, 10000);

        s1 = "adipiscinG";
        s2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        tester(s1, s2, 10);

        s1 = "cstnecuoter";
        s2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        tester(s1, s2, 1);
    }
}
