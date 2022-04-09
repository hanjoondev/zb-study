public class M0925 {
    public static void solution(int n) {
        recurTowers(n, 1, 3, 2);
    }

    public static void recurTowers(int n, int fr, int to, int aux) {
        if (n == 1) {
            System.out.printf("%d %d\n", fr, to);
            return;
        } else {
            recurTowers(n - 1, fr, aux, to);
            recurTowers(1, fr, to, aux);
            recurTowers(n - 1, aux, to, fr);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
    }
}

/* acmicpc submission
    // Source: 1914. 하노이 탑 https://www.acmicpc.net/problem/1914
    // Submission detail: https://www.acmicpc.net/source/41759310
    //     Runtime: 440 ms
    //     Memory Usage: 50092 KB
import java.io.*;
import java.math.*;

public class Main {
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
*/
