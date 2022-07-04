package acmicpc;

import java.io.IOException;
import java.io.InputStream;

public class A16401 {
    private static CustomScanner sc = new CustomScanner(System.in);

    public static void main(String[] args) {
        int niblings = sc.nextInt(), n = sc.nextInt(), ans = 0, l = 1, r = 0, i = 0, mid, cnt;
        int[] sticks = new int[n];
        for (; i < n; i++) if ((sticks[i] = sc.nextInt()) > r) r = sticks[i];
        while (l <= r) {
            mid =  l + (r - l) / 2;
            cnt = i = 0;
            while (i < n) cnt += sticks[i++] / mid;
            if (cnt >= niblings) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        System.out.println(ans);
    }

    static class CustomScanner {
        private InputStream in;
        private final byte[] buf = new byte[1048576];
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
