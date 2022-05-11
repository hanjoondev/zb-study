package acmicpc;

import java.io.*;

public class A01300 {
    public static int solution(int n, int k) {
        int low = 1, high = k;
        while (low <= high) {
            int mid = (low + high) / 2, count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }
            if (count >= k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.println(solution(n, k));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A01300 test = new A01300();
        test.reader();
    }
}
