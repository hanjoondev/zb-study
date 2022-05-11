package acmicpc;

import java.io.*;
import java.util.*;

public class A02110 {
    public static int solution(int[] coord, int n, int required) {
        Arrays.sort(coord);
        int low = 1, high = coord[n - 1];
        while (low <= high) {
            int dist = low + (high - low) / 2, prev = coord[0], count = 1;
            for (int i = 1; i < n; i++) {
                if (coord[i] - prev >= dist) {
                    prev = coord[i];
                    if (++count >= required) break;
                }
            }
            if (count < required)
                high = dist - 1;
            else
                low = dist + 1;
        }
        return high;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int coord[] = new int[n];
        for (int i = 0; i < n; i++)
            coord[i] = Integer.parseInt(br.readLine());
        System.out.println(solution(coord, n, c));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A02110 test = new A02110();
        test.reader();
    }
}
