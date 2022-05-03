package acmicpc;

import java.io.*;
import java.util.*;

public class A09012 {
    public boolean isValid(String s) {
        HashMap<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[' );
        }};
        List<Character> openers = new ArrayList<>() {{
            add('(');
            add('{');
            add('[');
        }};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (openers.contains(c)) {
                stack.push(c);
            } else {
                if (stack.contains(pairs.get(c))) {
                    if (pairs.get(c) != stack.peek())
                        return false;
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            bw.write(isValid(br.readLine()) ? "YES\n" : "NO\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        A09012 test = new A09012();
        test.solution();
    }
}
