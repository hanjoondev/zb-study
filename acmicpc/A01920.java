package acmicpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class A01920 {
    private static CustomScanner sc = new CustomScanner(System.in);
    private static PrintWriter pw = new PrintWriter(System.out);
    private static int[] a;
    private static int n, m;

    public static String solution(int required) {
        int low = 0, high = n - 1;
        if (a[0] > required || a[high] < required)
            return "0\n";
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == required)
                return "1\n";
            if (a[mid] < required)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return "0\n";
    }

    public void reader() {
        n = sc.nextInt();
        a = new int[n];
        int i = 0;
        while (i < n) a[i++] = sc.nextInt();
        Arrays.sort(a);
        m = sc.nextInt();
        while (m-- > 0) pw.write(solution(sc.nextInt()));
        pw.flush();
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        a = new int[n];
        int i = 0;
        while (i < n) a[i++] = sc.nextInt();
        Arrays.sort(a);
        m = sc.nextInt();
        while (m-- > 0) pw.write(solution(sc.nextInt()));
        pw.flush();
    }

    static class CustomScanner {
        private InputStream in;
        private final byte[] buf = new byte[524288];
        private int ptr = 0, lenBuf = 0;
    
        public CustomScanner(InputStream inStream) {
            in = inStream;
        }

        private void read() {
            ptr = 0;
            try {
                lenBuf = in.read(buf);
            } catch (IOException e) { }
        }

        private byte getByte() {
            if (ptr >= lenBuf) read();
            if (lenBuf < 0 || isSkippable(buf[ptr])) return -1;
            else return buf[ptr++];
        }

        private void skip() {
            for (; ptr < lenBuf; ptr++)
                if (!isSkippable(buf[ptr]))
                    return;
            read();
            skip();
        }

        private boolean isSkippable(byte b) {
            if (b <= ' ') return true;
            else return false;
        }

        public String next() {
            skip();
            StringBuilder sb = new StringBuilder();
            byte b;
            while ((b = getByte()) != -1) sb.appendCodePoint(b);
            return sb.toString();
        }

        public int nextInt() {
            skip();
            int n = 0;
            boolean minus = false;
            byte b;
            while ((b = getByte()) != -1) {
                if (b == '-')
                    minus = true;
                else {
                    n *= 10;
                    n += (b - '0');
                }
            }
            if (minus)
                return n * -1;
            else
                return n;
        }
    }
}
