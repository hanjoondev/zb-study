package acmicpc;

import java.io.*;
import java.util.*;

public class A01920 {
    public static String solution(int[] arr, int required, int length) {
        int low = 0, high = length - 1;
        if (arr[0] > required || arr[high] < required)
            return "0\n";
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == required)
                return "1\n";
            if (arr[mid] < required)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return "0\n";
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            sb.append(solution(arr, Integer.parseInt(st.nextToken()), n));
        System.out.println(sb);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A01920 test = new A01920();
        test.reader();
    }
}
