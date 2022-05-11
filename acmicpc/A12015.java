package acmicpc;

import java.io.*;
import java.util.*;

public class A12015 {
    public static int solution(int[] seq, int length) {
        ArrayList<Integer> q = new ArrayList<>();
        q.add(seq[0]);
        int ans = 1;
        for (int i = 1; i < seq.length; i++) {
            int num = seq[i];
            if (num > q.get(q.size() - 1)) {
                q.add(num);
                ans++;
                continue;
            }
            int low = 0, high = q.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (q.get(mid) < num)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            q.set(low, num);
        }
        return ans;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int seq[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            seq[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(seq, n));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A12015 test = new A12015();
        test.reader();
    }
}
