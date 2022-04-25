package acmicpc;

import java.io.*;
import java.util.*;

public class A17612 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        PriorityQueue<int[]> left = new PriorityQueue<>((x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        int[] timeLeft = new int[k];
        for (int i = 0; i < k; i++)
            queue.add(new int[] { 0, i, 0 });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
            int emptyLine = queue.poll()[1];
            timeLeft[emptyLine] += t;
            queue.add(new int[] { timeLeft[emptyLine], emptyLine, id });
            left.add(new int[] { timeLeft[emptyLine], emptyLine, id });
        }
        long ans = 0, i = 0;
        while (!left.isEmpty())
            ans += ++i * left.poll()[2];
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        A17612 test = new A17612();
        test.solution();
    }
}
