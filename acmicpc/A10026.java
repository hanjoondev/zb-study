package acmicpc;

import java.io.*;

public class A10026 {
    private static final int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static boolean[][] visited;
    private static boolean[][] visited_b;
    private static String[] map;

    public static void dfs(int r, int c, String color, int n) {
        boolean blind = color.length() > 1 ? true : false;
        for (int[] d : dir) {
            int nr = r + d[0], nc = c + d[1];
            if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                if (color.indexOf(Character.toString(map[nr].charAt(nc))) >= 0) {
                    if (!blind && !visited[nr][nc]) {                        
                        visited[nr][nc] = true;
                        dfs(nr, nc, color, n);
                    }
                    if (blind && !visited_b[nr][nc]) {
                        visited_b[nr][nc] = true;
                        dfs(nr, nc, color, n);
                    }
                }
            }
        }
    }

    public static void solution(int n) {
        visited = new boolean[n][n];
        visited_b = new boolean[n][n];
        int areas = 0, areas_rg_blind = 0;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++) {
                if (!visited[r][c]) {
                    dfs(r, c, Character.toString(map[r].charAt(c)), n);
                    areas++;
                }
                if (!visited_b[r][c]) {
                    String color = Character.toString(map[r].charAt(c));
                    dfs(r, c, color.equals("R") 
                           || color.equals("G") ? "RG" : "BB", n);
                    areas_rg_blind++;
                }
            }
        System.out.println(areas + " " + areas_rg_blind);
    }

    public void reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new String[n];
        for (int i = 0; i < n; i++)
            map[i] = br.readLine();
        solution(n);
    }

    public static void main(String[] args) throws IOException {
        A10026 test = new A10026();
        test.reader();
    }
}
