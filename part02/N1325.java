import java.util.ArrayList;
import java.util.HashMap;

class N1325Node {
    HashMap<Character, N1325Node> child;
    boolean isTerminal;

    public N1325Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class N1325Trie {
    N1325Node root;

    public N1325Trie() {
        this.root = new N1325Node();
    }

    public void insert(String str) {
        N1325Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new N1325Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        N1325Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class N1325 {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {

        return null;
    }

    public static void main(String[] args) {
        // Test code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }
}
