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
