package acmicpc;

import java.io.*;
import java.util.StringTokenizer;

public class A02389 {
    public static void solution(double[] a, double[] b, double xs, double ys, int len) {
        double d = 0.0, e = 0.0, p = 0.1;
        for (int i = 0; i < 25000; i++) {
            int f = 0;
            d = (xs - a[0]) * (xs - a[0]) + (ys - b[0]) * (ys - b[0]);
            for (int j = 1; j < len; j++) {
                e = (xs - a[j]) * (xs - a[j]) + (ys - b[j]) * (ys - b[j]);
                if (d < e) {
                    d = e;
                    f = j;
                }
            }
            xs += (a[f] - xs) * p;
            ys += (b[f] - ys) * p;
            p *= 0.999;
        }
        System.out.printf("%.10f %.10f %.10f\n", xs, ys, Math.sqrt(d));
    }

    public void reader() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        double xsum = 0.0, ysum = 0.0;
        double[] a = new double[n + 1], b = new double[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Double.parseDouble(st.nextToken());
            b[i] = Double.parseDouble(st.nextToken());
            xsum += a[i];
            ysum += b[i];
        }
        solution(a, b, xsum / n, ysum / n, n);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        A02389 test = new A02389();
        test.reader();
    }
}
