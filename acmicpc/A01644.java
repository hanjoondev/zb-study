package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A01644 {
    private static int count = 0;

    private static int[] getPrimes(int n) {
        if (n < 2) return new int[0];
        boolean[] sieve = new boolean[n / 2 + 1];
        for (int i = 3 ; i * i <= n; i += 2)
            if (!sieve[i / 2])
                for (int j = i * i; j <= n; j += i * 2)
                    sieve[j / 2] = true;
        int[] primes = new int[n / 2 + 2];
        primes[0] = 2;
        count++;
        for (int i = 3; i <= n; i += 2)
            if (!sieve[i / 2])
                primes[count++] = i;
        return primes;
    }

    private static int twoPointer(int n) {
        int[] p = getPrimes(n);
        if (count == 0) return 0;
        int slow = 0, fast = 0, sum = 0, ans = 0;
        while (fast <= count) {
            if (sum < n) {
                sum += p[fast++];
            } else {
                if (sum == n) ans++;
                sum -= p[slow++];
            }
        }
        return ans;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(twoPointer(Integer.parseInt(br.readLine())));
    }

    public static void main (String[] args) throws NumberFormatException, IOException {
        A01644 test = new A01644();
        test.reader();
    }
}
