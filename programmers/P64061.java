package programmers;

import java.util.Stack;

public class P64061 {
    public int solution(int[][] board, int[] moves) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int picked = -1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    picked = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }
            if (picked != -1) {
                if (!stack.isEmpty() && stack.peek() == picked) {
                    stack.pop();
                    ans += 2;
                } else {
                    stack.push(picked);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P64061().solution(new int[][]
        { {0, 0, 0, 0, 0},
          {0, 0, 1, 0, 3},
          {0, 2, 5, 0, 1},
          {4, 2, 4, 4, 2},
          {3, 5, 1, 3, 1} },
        new int[] { 1, 5, 3, 5, 1, 2, 1, 4 } ));
    }
}
