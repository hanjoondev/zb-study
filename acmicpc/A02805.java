package acmicpc;

import java.io.*;
import java.util.*;

public class A02805 {
    public static long solution(int[] trees, int required) {
        long low = 0L, high = 2_000_000_000L;
        while (low <= high) {
            long cuttingHeight = low + (high - low) / 2, remainders = 0L;
            for (int tree : trees)
                remainders += tree > cuttingHeight ? tree - cuttingHeight : 0L;
            if (remainders < required)
                high = cuttingHeight - 1L;
            else
                low = cuttingHeight + 1L;
        }
        return high;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int trees[] = new int[n];
        for (int i = 0; i < n; i++)
            trees[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(trees, m));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A02805 test = new A02805();
        test.reader();
    }
}
