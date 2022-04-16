package acmicpc;

import java.io.*;
import java.math.*;

public class A01914 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
        bw.write(count.toString() + "\n");
        if (n <= 20)
            rT(n, 1, 3, 2);
        bw.flush();
        bw.close();
    }

    public static void rT(int n, int fr, int to, int aux) throws IOException {
        if (n == 1) {
            bw.write(fr + " " + to + "\n");
            return;
        }
        rT(n - 1, fr, aux, to);
        bw.write(fr + " " + to + "\n");
        rT(n - 1, aux, to, fr);
    }
}

/* input 1
3
*/
/* output 1
7
1 3
1 2
3 2
1 3
2 1
2 3
1 3
*/
