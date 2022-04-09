import java.util.ArrayList;
import java.util.Stack;

public class L1422 {
    public static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<String> ans = new ArrayList<String>();

        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            while (count <= target) {
                stack.push(count);
                ans.add("+");
                count++;
            }
            if (stack.peek() == target) {
                stack.pop();
                ans.add("-");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.printf(String.join(" ", ans));
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1};
        solution(nums);

        System.out.println("=====");
        nums = new int[]{1, 2, 5, 3, 4};
        solution(nums);
    }
}

/* acmicpc submission
    // Source: 1874. 스택 수열 https://www.acmicpc.net/problem/1874
    // Submission detail: https://www.acmicpc.net/source/41762939
    //     Runtime: 352 ms
    //     Memory Usage: 27364 KB
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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
*/
