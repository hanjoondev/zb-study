package acmicpc;

import java.io.*;
import java.util.*;

public class A01406 {
    public void solution() throws IOException {
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

    public static void main(String[] args) throws IOException {
        A01406 test = new A01406();
        test.solution();
    }
}
