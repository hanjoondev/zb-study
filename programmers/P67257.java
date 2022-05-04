package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class P67257 {
    private Long calc(Long a, Long b, char op) {
        Long result;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            default:
                result = a * b;
                break;
        }
        return result;
    }

    public long solution(String exp) {
        ArrayDeque<Long> nums = new ArrayDeque<>();
        ArrayDeque<Character> ops = new ArrayDeque<>();
        HashMap<Character, Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                nums.offer(Long.parseLong(sb.toString()));
                ops.offer(c);
                count.put(c, count.getOrDefault(c, 0) + 1);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
        long ans = 0, sum;
        for (String op_order : new String[] { "+-*", "+*-", "*+-", "*-+", "-+*", "-*+" }) {
            ArrayList<Long> nums_ = new ArrayList<>(nums);
            ArrayList<Character> ops_ = new ArrayList<>(ops);
            for (char op : op_order.toCharArray()) {
                int i = 0, op_count = 0, op_target = count.getOrDefault(op, 0);
                while (op_count < op_target) {
                    if (ops_.get(i) == op) {
                        nums_.set(i, calc(nums_.get(i), nums_.get(i + 1), op));
                        nums_.remove(i + 1);
                        ops_.remove(i);
                        op_count++;
                        continue;
                    }
                    i++;
                }
            }
            if ((sum = Math.abs(nums_.get(0))) > ans)
                ans = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P67257().solution("100-200*300-500+20"));
        System.out.println(new P67257().solution("50*6-3*2"));
    }
}
