package acmicpc;

import java.io.*;
import java.util.*;

public class A03190 {
    static int[][] map;
    static Queue<List<Integer>> moves = new LinkedList<>();

    public static int solution(int n, int k, int l) {
        Queue<List<Integer>> snake = new LinkedList<>();
        snake.add(Arrays.asList(0, 0));
        int[][] dmap = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int timer = 0, d = 0, r = 0, c = 0;
        int t = moves.peek().get(0);
        while (true) {
            timer++;
            r += dmap[d][0];
            c += dmap[d][1];
            if (r < 0 || c < 0 || r == n || c == n || map[r][c] < 0)
                return timer;
            snake.add(Arrays.asList(r, c));
            if (map[r][c] == 0) {
                List<Integer> tail = snake.poll();
                map[tail.get(0)][tail.get(1)] = 0;
            }
            map[r][c] = -1;
            if (timer == t && moves.peek() != null) {
                List<Integer> move = moves.poll();
                int td = move.get(1);
                d = d + td == 4 ? 0 : d + td == -1 ? 3 : d + td;
                t = moves.peek() != null ? moves.peek().get(0) : 0;
            }
        }
    }

    public void reader () throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int m = st.nextToken().equals("D") ? 1 : -1;
            moves.add(Arrays.asList(t, m));
        }
        System.out.println((solution(n, k, l)));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A03190 test = new A03190();
        test.reader();
    }
}
