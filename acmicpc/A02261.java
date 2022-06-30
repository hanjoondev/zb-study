package acmicpc;

import java.io.*;
import java.util.*;

public class A02261 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int dist(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private static int solution(Point[] pts, int n) {
        Arrays.sort(pts, (p1, p2) -> p1.x - p2.x);
        TreeSet<Point> ts = new TreeSet<Point>((p1, p2) -> p1.y == p2.y
                                                         ? p1.x - p2.x
                                                         : p1.y - p2.y);
        ts.add(pts[0]);
        int min = dist(pts[0], pts[1]), idx = 0;
        for(int i = 1; i < n; i++) {
            Point cand = pts[i];
            while (idx < i && (cand.x - pts[idx].x) * (cand.x - pts[idx].x) > min)
                ts.remove(pts[idx++]);
            for (Point p : ts.subSet(new Point(-100000, cand.y - (int) Math.sqrt(min) + 1),
                                     new Point(100000, cand.y + (int) Math.sqrt(min) + 1)))
                min = Math.min(min, dist(cand, p));
            ts.add(cand);
        }
        return min;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pts[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(solution(pts, n));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A02261 test = new A02261();
        test.reader();
    }
}
