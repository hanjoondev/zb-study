package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A01644 {
    private static ArrayList<Integer> getPrimes(int n) {
        if (n < 2) return new ArrayList<Integer>();
        boolean[] sieve = new boolean[n / 2 + 1];
        for (int i = 3 ; i * i <= n; i += 2)
            if (!sieve[i / 2])
                for (int j = i * i; j <= n; j += i * 2)
                    sieve[j / 2] = true;
        return new ArrayList<Integer>() {{ 
            add(2);
            for (int i = 3; i <= n; i += 2) if (!sieve[i / 2]) add(i);
        }};
    }

    private static int twoPointer(int n) {
        ArrayList<Integer> p = getPrimes(n);
        if (p.size() == 0) return 0;
        int slow = 0, fast = 0, sum = p.get(fast), ans = 0, len = p.size();
        while (slow <= fast) {
            if (sum < n) {
                if (++fast == len) break;
                sum += p.get(fast);
            } else {
                ans += sum == n ? 1 : 0;
                sum -= p.get(slow++);
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
