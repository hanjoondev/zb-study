package unknown;

import java.util.*;
import java.util.stream.*;

public class U231332 {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(int n, boolean[][] lit, HashMap<List<Integer>, List<int[]>> sInfo) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        int flips = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            List<Integer> key = Arrays.stream(pos).boxed().collect(Collectors.toList());
            if (sInfo.containsKey(key))
                for (int[] sw : sInfo.get(key)) 
                    if (!lit[sw[0]][sw[1]]) {
                        lit[sw[0]][sw[1]] = true;
                        flips++;
                    }
            for (int[] d : directions) {
                int r = pos[0] + d[0], c = pos[1] + d[1];
                if (r >= 0 && r < n && c >= 0 && c < n && lit[r][c] && !visited[r][c]) {
                    visited[r][c] = true;
                    queue.offer(new int[] {r, c});
                }
            }
        }
        return flips > 0 ? flips + bfs(n, lit, sInfo) : flips;
    }

    public static int solution(int n, int[][] switches) {
        Arrays.sort(switches, (a, b) -> a[0] - b[0]);
        boolean[][] lit = new boolean[n][n];
        lit[0][0] = true;
        HashMap<List<Integer>, List<int[]>> sInfo = new HashMap<>();
        for (int[] s : switches)
            sInfo.computeIfAbsent(Arrays.asList(s[0] - 1, s[1] - 1), k -> new ArrayList<>())
                 .add(new int[] {s[2] - 1, s[3] - 1});
        return bfs(n, lit, sInfo) + 1;
    }

    public static void main(String[] args) {
        int[][] switches = {{1, 1, 1, 2}, {2, 1, 2, 2}, {1, 1, 1, 3}, {2, 3, 3, 1}, {1, 3, 1, 2}, {1, 3, 2, 1}};
        System.out.println(solution(3, switches));
    }
}
