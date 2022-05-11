package acmicpc;

import java.io.*;
import java.util.*;

public class A05670 {
    class Trie {
        Trie[] children;
        int numChildren;
        boolean isEnd;
        private List<String> wordsList;

        public Trie() {
            this.children = new Trie[26];
            this.wordsList = new ArrayList<>();
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            node.wordsList.add(word);
            for (int i = 0; i < word.length(); i++) {
                int alphabet = word.charAt(i) - 'a';
                if (node.children[alphabet] == null) {
                    node.children[alphabet] = new Trie();
                    node.numChildren++;
                }
                node = node.children[alphabet];
            }
            node.isEnd = true;
        }

        public int count(String word) {
            int cnt = 1;
            Trie node = this.children[word.charAt(0) - 'a'];
            for (int i = 1; i < word.length(); i++) {
                if (node.numChildren > 1 || node.isEnd)
                    cnt++;
                node = node.children[word.charAt(i) - 'a'];
            }
            return cnt;
        }

        public List<String> getWordsList() {
            return this.wordsList;
        }
    }

    public void reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String lineStart;
        while ((lineStart = br.readLine()) != null) {
            int n = Integer.parseInt(lineStart);
            Trie trie = new Trie();
            for (int i = 0; i < n; i++)
                trie.insert(br.readLine());
            double ans = 0;
            for (String word : trie.getWordsList())
                ans += trie.count(word);
            bw.write(String.format("%.2f\n", ans / n));
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        A05670 test = new A05670();
        test.reader();
    }
}
