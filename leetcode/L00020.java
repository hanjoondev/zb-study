package leetcode;

import java.util.*;

public class L00020 {
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
}
