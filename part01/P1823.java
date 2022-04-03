import java.util.ArrayList;
import java.util.Arrays;

public class P1823 {
    public static String solution(String input, String cmd) {
        ArrayList<String> c = new ArrayList<>(Arrays.asList(cmd.split(" ")));
        int pos = input.length();
        while (c.size() > 0) {
            String first = c.get(0);
            int iLen = input.length();
            if (first.equals("L") && pos != 0) {
                pos--;
            } else if (first.equals("D") && pos != iLen) {
                pos++;
            } else if (first.equals("B") && pos != 0 && iLen > 0) {
                input = input.substring(0, pos - 1) + input.substring(pos, iLen);
            } else if (first.equals("P")) {
                input = input.substring(0, pos) + c.get(1) + input.substring(pos, iLen);
                pos++;
                c.remove(1);
            }
            c.remove(0);
        }
        return input;
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
