package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A02075 {
    public static int partition(int[] arr, int l, int r) {
        int idx = l, val = arr[r];
        for (int i = l; i < r; i++) {
            if (arr[i] <= val) {
                int tmp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = tmp;
                idx++;
            }
        }
        int tmp = arr[idx];
        arr[idx] = arr[r];
        arr[r] = tmp;
        return idx;
    }

    public static int quickSelect(int[] arr, int l, int r, int n) {
        if (n <= r - l + 1 && n != 0) {
            int i = partition(arr, l, r);
            if (i == n + l - 1) return arr[i];
            else if (i > n + l - 1) return quickSelect(arr, l, i - 1, n);
            else return quickSelect(arr, i + 1, r, n - i + l - 1);
        }
        return 0;
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i * n + j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(quickSelect(arr, 0, arr.length - 1, arr.length - n + 1));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A02075 test = new A02075();
        test.reader();
    }
}
