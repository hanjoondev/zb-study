package acmicpc;

import java.io.*;
import java.util.*;

public class A01654 {
    public static long solution(int[] cables, int num_cables, int required) {
        long low = 0L, high = 2_147_483_648L - 1;
        while (low <= high) {
            long length = low + (high - low) / 2, count = 0L;
            for (int cable : cables)
                count += cable / length;
            if (count < required)
                high = length - 1L;
            else
                low = length + 1L;
        }
        return high;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        int[] cables = new int[k];
        for (int i = 0; i < k; i++)
            cables[i] = Integer.parseInt(br.readLine());
        System.out.println(solution(cables, k, n));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A01654 test = new A01654();
        test.reader();
    }
}
