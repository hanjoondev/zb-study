package kickstart;

import java.util.*;

public class K22A1 {
    public void reader() {
        Scanner sc = new Scanner(System.in);
        int numCases = Integer.parseInt(sc.nextLine());
        String[] I = new String[numCases], P = new String[numCases];
        for (int i = 0; i < numCases; i++) {
            I[i] = sc.nextLine();
            P[i] = sc.nextLine();
        }
        sc.close();
        for (int i = 0; i < numCases; i++)
            System.out.printf("Case #%d: %s\n", i + 1, solver(I[i], P[i]));
    }

    public static String solver(String I, String P) {
        int ans = 0, j = 0;
        for (int i = 0; i < P.length(); i++)
            if (j < I.length() && I.charAt(j) == P.charAt(i))
                j++;
            else
                ans++;
        return j == I.length() ? String.valueOf(ans) : "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        K22A1 k22A1 = new K22A1();
        k22A1.reader();
    }
}
