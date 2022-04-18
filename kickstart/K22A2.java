package kickstart;

import java.io.*;

public class K22A2 {
    public void reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCases; i++)
            bw.write(String.format("Case #%d: %s\n", i + 1, solver(br.readLine())));
        bw.flush();
        bw.close();
    }

    public static String solver(String N) {
        int sum = N.chars().map(c -> Character.digit(c, 10)).sum();
        int missing = (9 - sum % 9) % 9;
        for (int i = missing == 0 ? 1 : 0; i < N.length(); i++)
            if (N.charAt(i) > missing + '0')
                return new StringBuilder(N).insert(i, missing).toString();
        return new StringBuilder(N).append(missing).toString();
    }

    public static void main(String[] args) throws IOException {
        K22A2 test = new K22A2();
        test.reader();
    }
}
