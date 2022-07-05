package acmicpc;

import java.io.DataInputStream;
import java.io.IOException;

public class A16234 {
    private static CustomReader sc = new CustomReader();
    private static int[][] a, v;
    private static int[] u = new int[2501];
    private static int id, sumPopulation, lenUnion;
    private static int n, m, nn, lo, hi, ans = 0;

    static boolean isJoinable(int a, int b) {
        int diff = a - b > 0 ? a - b : b - a;
        return lo <= diff && diff <= hi ? true : false;
    }

    static void dfs(int r, int c) {
        v[r][c] = id;
        sumPopulation += a[r][c];
        lenUnion++;
        if (r > 0 && v[r - 1][c] == 0 && isJoinable(a[r][c], a[r - 1][c])) dfs(r - 1, c);
        if (r < m && v[r + 1][c] == 0 && isJoinable(a[r][c], a[r + 1][c])) dfs(r + 1, c);
        if (c > 0 && v[r][c - 1] == 0 && isJoinable(a[r][c], a[r][c - 1])) dfs(r, c - 1);
        if (c < m && v[r][c + 1] == 0 && isJoinable(a[r][c], a[r][c + 1])) dfs(r, c + 1);
    }

    static int solution() {
        while (true) {
            id = 0;
            for (int r = 0; r < n; r++) for (int c = 0; c < n; c++) {
                if (v[r][c] == 0) {
                    id++;
                    sumPopulation = lenUnion = 0;
                    dfs(r, c);
                    u[id] = sumPopulation / lenUnion;
                }
            }
            if (id == nn) return ans;
            ans++;
            for(int r = 0; r < n; r++) for(int c = 0; c < n; c++) { 
                a[r][c] = u[v[r][c]]; v[r][c] = 0; 
            }
        }
    }

    public void reader() {
        n = sc.nextInt(); lo = sc.nextInt(); hi = sc.nextInt();
        m = n - 1; nn = n * n;
        a = new int[n][n]; v = new int[n][n];
        for (int r = 0; r < n; r++) for (int c = 0; c < n; c++) a[r][c] = sc.nextInt();
        System.out.println(solution());
    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt(); lo = sc.nextInt(); hi = sc.nextInt();
        m = n - 1; nn = n * n;
        a = new int[n][n]; v = new int[n][n];
        for (int r = 0; r < n; r++) for (int c = 0; c < n; c++) a[r][c] = sc.nextInt();
        System.out.println(solution());
    }

    static class CustomReader {
        final private int BUFFER_SIZE = 1 << 19;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public CustomReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private byte read() {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public String readLine() {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    if (cnt != 0) break;
                    else continue;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            } catch (IOException e) { }
            if (bytesRead == -1) buffer[0] = -1;
        }
    }
}
