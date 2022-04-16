package acmicpc;

import java.io.*;
import java.util.*;

public class A01874 {
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

/* input 1
8
4
3
6
8
7
5
2
1
*/
/* output 1
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
*/

/* input 2
5
1
2
5
3
4
*/
/* output 2
NO
*/
