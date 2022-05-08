package programmers;

import java.util.Arrays;

public class P43236 {
    public int solution(int d, int[] rocks, int n) {
        Arrays.sort(rocks);
        int l = 0, h = d;
        while (l + 1 < h) {
            int dist = (l + h) / 2;
            int removed = 0, prev = 0;
            for (int rock : rocks) {
                if (rock - prev < dist) {
                    if (++removed > n) break;
                } else {
                    prev = rock;
                }
            }
            removed += d - prev < dist ? 1 : 0;
            if (removed > n) h = dist;
            else l = dist;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new P43236().solution(25, new int[] { 2, 4, 11, 21, 17 }, 2));
    }
}
