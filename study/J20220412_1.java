import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J20220412_1 {
// public class Main {
    public static void solution(int[] data) {
        StringBuilder sb = new StringBuilder();
        int len = data.length, remaining = data.length - 1, nxt = data[0];
        int cur = 0, dir = nxt > 0 ? 1 : -1;
        int[] popped = new int[len];
        popped[cur] = 1;
        sb.append(cur + 1 + " ");
        while (remaining > 0) {
            int moveCount = 0;
            while (moveCount < Math.abs(nxt)) {
                cur += dir;
                cur = cur == len ? 0 : cur < 0 ? len - 1 : cur;
                moveCount += popped[cur] == 0 ? 1 : 0;
            }
            popped[cur] = 1;
            sb.append(cur + 1 + " ");
            nxt = data[cur];
            dir = nxt > 0 ? 1 : -1;
            remaining--;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] balloon = new int[len];
        String[] ball = br.readLine().split(" ");
        for (int i = 0; i < len; i++)
            balloon[i] = Integer.parseInt(ball[i]);
        solution(balloon);
    }
}
