package acmicpc;

import java.io.*;

public class A16934 {
    class Trie {
        Trie[] children;
        int count;

        public Trie() {
            this.children = new Trie[26];
            this.count = 0;
        }

        public String insert(String word) {
            Trie node = this;
            int found = word.length();
            boolean firstBranch = true;
            for (int i = 0; i < word.length(); i++) {
                int alphabet = word.charAt(i) - 'a';
                if (node.children[alphabet] == null) {
                    node.children[alphabet] = new Trie();
                    if (firstBranch) {
                        found = i + 1;
                        firstBranch = false;
                    }
                }
                node = node.children[alphabet];
            }
            node.count++;
            return word.substring(0, found) + (node.count > 1 ? node.count : "");
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++)
            bw.write(trie.insert(br.readLine()) + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        A16934 test = new A16934();
        test.solution();
    }
}
