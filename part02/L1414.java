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
                } else
                    expecting = expecting.substring(1);
            } 
        }
        System.out.println("Pass");
    }

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
