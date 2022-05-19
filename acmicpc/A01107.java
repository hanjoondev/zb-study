package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A01107 {
    private static int target, length, ans, digits;
    private static int[] available;

    public static void brute(int num, int d, int started) {
        int v = d + (target > num ? target - num : num - target);
        ans = ans < v ? ans : v;
        if (d < digits || d == digits && started == 1)
            for (int a : available)
                brute(num * 10 + a, d + 1, started);
    }

    public static void solution() {
        digits = String.valueOf(target).length();
        ans = digits > 2 ? target - 100 : 100 - target;
        if (length == 10 || target == 100 || length == 0) {
            System.out.println(length == 10 || target == 100 ? ans 
                                                             : ans < digits ? ans : digits);
            return;
        }
        for (int a : available)
            brute(a, 1, a);
        System.out.println(ans);
    }

    public void reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        length = Integer.parseInt(br.readLine());
        available = new int[10 - length];
        if (length > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] broken = new boolean[10];
            for (int i = 0; i < length; i++)
                broken[Integer.parseInt(st.nextToken())] = true;
            int j = 0;
            for (int i = 0; i < 10; i++)
                if (!broken[i])
                    available[j++] = i;
        }
        solution();
    }

    public static void main(String[] args) throws IOException {
        A01107 test = new A01107();
        test.reader();
    }
}
