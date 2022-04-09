public class L1414 {
    public static void solution(String str) {
        String openers = "({[", closers = ")}]", expecting = "";
        for (char c : str.toCharArray()) {
            int oi = openers.indexOf(c), ci = closers.indexOf(c);
            if (oi != -1)
                expecting = closers.charAt(oi) + expecting;
            else if (ci != -1 && expecting.length() > 0) {
                if (c != expecting.charAt(0)) {
                    System.out.println("Fail");
                    return;
                } else {
                    expecting = expecting.substring(1);
                }
            } else {
                System.out.println("Fail");
                return;
            }
        }
        System.out.println("Pass");
    }

/* leetcode submission
    // Source: 20. Valid Parentheses https://leetcode.com/problems/valid-parentheses/
    // Submission detail: https://leetcode.com/submissions/detail/676706211/
    //     Runtime: 18 ms, faster than 6.06% of Java online submissions for Valid Parentheses.
    //     Memory Usage: 54.8 MB, less than 6.10% of Java online submissions for Valid Parentheses.
    public boolean isValid(String s) {
        String openers = "({[", closers = ")}]", expecting = "";
        for (char c : s.toCharArray()) {
            int oi = openers.indexOf(c), ci = closers.indexOf(c);
            if (oi != -1)
                expecting = closers.charAt(oi) + expecting;
            else if (ci != -1 && expecting.length() > 0)
                if (c != expecting.charAt(0))
                    return false;
                else
                    expecting = expecting.substring(1);
            else
                return false;
        }
        return expecting.length() > 0 ? false : true;
    }
*/

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
