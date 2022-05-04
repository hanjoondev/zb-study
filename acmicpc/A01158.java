package acmicpc;

import java.io.*;
import java.util.*;

public class A01158 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (i % K == 0) 
                sb.append(Integer.toString(i).concat(", "));
            else
                q.add(i);
        }
        int i = N % K;
        while (!q.isEmpty()) {
            if (++i % K == 0)
                sb.append(Integer.toString(q.poll()).concat(", "));
            else
                q.add(q.poll());
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) throws IOException {
        A01158 test = new A01158();
        test.solution();
    }
}
