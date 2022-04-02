public class L1414 {
    public static void solution(String str) {

    }

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
