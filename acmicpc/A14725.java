package acmicpc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.TreeSet;

public class A14725 {
    private static CustomScanner sc = new CustomScanner(System.in);
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(Trie t, int d) {
        if (d != -1) {
            for (int i = 0; i < d; i++) sb.append("--");
            sb.append(t.name).append("\n");
        }
        for (String child : t.ts) dfs(t.children.get(child), d + 1);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        Trie root = new Trie("");
        while (n-- > 0) {
            int k = sc.nextInt();
            Trie node = root;
            for (int i = 0; i < k; i++) {
                String t = sc.next();
                node = node.add(t);
            }
        }
        dfs(root, -1);
        System.out.println(sb.toString());
    }

    static class Trie {
        String name;
        HashMap<String, Trie> children;
        TreeSet<String> ts;

        Trie(String name) {
            this.name = name;
            this.children = new HashMap<>();
            this.ts = new TreeSet<>();
        }

        public Trie add(String name) {
            Trie node = this;
            if (!node.children.containsKey(name)) {
                node.children.put(name, new Trie(name));
                node.ts.add(name);
            }
            node = node.children.get(name);
            return node;
        }
    }

    static class CustomScanner {
        private InputStream iStream;
        private final byte[] buf = new byte[524288];
        private int ptr = 0, lenBuf = 0;
    
        public CustomScanner(InputStream inStream) {
            iStream = inStream;
        }

        private void read() {
            ptr = 0;
            try {
                lenBuf = iStream.read(buf);
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
            byte bte;
            while ((bte = getByte()) != -1) sb.appendCodePoint(bte);
            return sb.toString();
        }

        public int nextInt() {
            skip();
            int nxtInt = 0;
            byte bte = getByte();
            boolean neg = bte == '-';
            if (neg) bte = getByte();
            do {
                nxtInt = nxtInt * 10 + bte - '0';
            } while ((bte = getByte()) != -1);
            return neg ? -nxtInt : nxtInt;
        }
    }
}
