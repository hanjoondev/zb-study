package acmicpc;

import java.io.*;
import java.util.*;

public class A01406 {
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

/* input 1
abcd
3
P x
L
P y
*/
/* output 1
abcdyx
*/

/* input 2
abc
9
L
L
L
L
L
P x
L
B
P y
*/
/* output 2
yxabc
*/

/* input 3
dmih
11
B
B
P x
L
B
B
B
P y
D
D
P z
*/
/* output 3
yxz
*/
