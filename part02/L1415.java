import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L1415 {
    public static int solution(int n, int k, int l, ArrayList<List<Integer>> apples, Queue<List<String>> moves) {
        int[][] map = new int[n][n];
        int[][] dmap = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (List<Integer> a : apples)
            map[a.get(0) - 1][a.get(1) - 1] = 1;
        Queue<List<Integer>> snake = new LinkedList<>();
        snake.add(Arrays.asList(0, 0));
        int timer = 0, d = 0, r = 0, c = 0;
        int t = Integer.parseInt(moves.peek().get(0));
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
                List<String> move = moves.poll();
                int nd = move.get(1).equals("D") ? 1 : -1;
                d = d + nd == 4 ? 0 : d + nd == -1 ? 3 : d + nd;
                t = Integer.parseInt(moves.peek() != null ? moves.peek().get(0) : "0");
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<List<Integer>> apples = new ArrayList<>();
        apples.add(Arrays.asList(3, 4));
        apples.add(Arrays.asList(2, 5));
        apples.add(Arrays.asList(5, 3));

        Queue<List<String>> moves = new LinkedList<>();
        moves.add(Arrays.asList("3", "D"));
        moves.add(Arrays.asList("15", "L"));
        moves.add(Arrays.asList("7", "D"));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 4;
        l = 4;
        apples.clear();
        apples.add(Arrays.asList(1, 2));
        apples.add(Arrays.asList(1, 3));
        apples.add(Arrays.asList(1, 4));
        apples.add(Arrays.asList(1, 5));

        moves.clear();
        moves.add(Arrays.asList("8", "D"));
        moves.add(Arrays.asList("10", "D"));
        moves.add(Arrays.asList("11", "D"));
        moves.add(Arrays.asList("13", "L"));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 5;
        l = 4;
        apples.clear();
        apples.add(Arrays.asList(1, 5));
        apples.add(Arrays.asList(1, 3));
        apples.add(Arrays.asList(1, 2));
        apples.add(Arrays.asList(1, 6));
        apples.add(Arrays.asList(1, 7));

        moves.clear();
        moves.add(Arrays.asList("8", "D"));
        moves.add(Arrays.asList("10", "D"));
        moves.add(Arrays.asList("11", "D"));
        moves.add(Arrays.asList("13", "L"));
        System.out.println((solution(n, k, l, apples, moves)));
    }
}

/* acmicpc submission
    // Source: 3190. 뱀 https://www.acmicpc.net/problem/3190
    // Submission detail: https://www.acmicpc.net/source/41762889
    //     Runtime: 136 ms
    //     Memory Usage: 14688 KB
import java.io.*;
import java.util.*;

public class Main {
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

    public static void main(String[] args) throws NumberFormatException, IOException {
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
}
*/
