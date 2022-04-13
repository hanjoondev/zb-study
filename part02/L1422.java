import java.util.ArrayList;
import java.util.Stack;

public class L1422 {
    public static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> ans = new ArrayList<>();

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
import java.io.*;
import java.util.*;

public class Main {
    public static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            while (count <= target) {
                stack.push(count);
                sb.append("+" + "\n");
                count++;
            }
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-" + "\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());
        solution(nums);
    }
}
*/
