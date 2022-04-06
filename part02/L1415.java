import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L1415 {
    public static int solution(int n, int k, int l, ArrayList<List<Integer>> apples, Queue<List<String>> moves) {
        int[][] map = new int[n][n];
        for (List<Integer> a : apples)
            map[a.get(0) - 1][a.get(1) - 1] = 2;
        int timer = 0, d = 0;
        int[][] dd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<List<Integer>> snake = new LinkedList<>();
        snake.add(Arrays.asList(0, 0));
        int nt = Integer.parseInt(moves.peek().get(0)), nd = d;
        int r = 0, c = 0;
        while (true) {
            timer++;
            r += dd[d][0];
            c += dd[d][1];
            if (r < 0 || c < 0 || r == n || c == n)
                return timer;
            for (List<Integer> pos : snake)
                if (r == pos.get(0) && c == pos.get(1))
                    return timer;
            snake.add(Arrays.asList(r, c));
            if (map[r][c] == 0)
                snake.poll();
            if (timer == nt) {
                List<String> move = moves.poll();
                if (move != null) {
                    nd = move.get(1).equals("D") ? 1 : -1;
                    nd = d + nd == dd.length ? 0 : d + nd == -1 ? dd.length - 1 : d + nd;
                }
                nt = Integer.parseInt(moves.peek() != null ? moves.peek().get(0) : "0");
                d = nd;
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
