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

/* acmicpc submission
    // Source: 1406. 에디터 https://www.acmicpc.net/problem/1406
    // Submission detail: https://www.acmicpc.net/source/41723152
    //     Runtime: 672 ms
    //     Memory Usage: 81168 KB
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> l = new Stack<String>(), r = new Stack<String>();
        String text = br.readLine();
        for (String s : text.split(""))
            l.push(s);
        int numCommands = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCommands; i++) {
            String command = br.readLine();
            if (command.equals("L") && !l.isEmpty()) {
                r.push(l.pop());
            } else if (command.equals("D") && !r.isEmpty()) {
                l.push(r.pop());
            } else if (command.equals("B") && !l.isEmpty()) {
                l.pop();
            } else if (command.startsWith("P")) {
                l.push(String.valueOf(command.charAt(2)));
            }
        }
        while (!l.isEmpty())
            r.push(l.pop());
        while (!r.isEmpty())
            bw.write(r.pop());
        bw.flush();
        bw.close();

    }
}
*/

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
