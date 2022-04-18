package kickstart;

import java.io.*;

public class K22A1 {
    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCases; i++)
            bw.write(String.format("Case #%d: %s\n", i + 1, 
                                    solver(br.readLine(), br.readLine())));
        bw.flush();
        bw.close();
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

    public static void main(String[] args) throws NumberFormatException, IOException {
        K22A1 k22A1 = new K22A1();
        k22A1.reader();
    }
}
