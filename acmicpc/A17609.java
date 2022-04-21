package acmicpc;

import java.io.*;

public class A17609 {
    public void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
            bw.write(String.valueOf(ans) + "\n");
        }
        bw.flush();
        bw.close();
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

    public static void main(String[] args) throws IOException {
        A17609 test = new A17609();
        test.solution();
    }
}
