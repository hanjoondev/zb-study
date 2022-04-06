import java.util.ArrayList;
import java.util.List;

public class M0923 {
    public static String solution(String equation) {
        int eqIdx = equation.indexOf("=");
        if (eqIdx < 0)
            return "Infinite solutions";
        int[] l = evaluate(equation.substring(0, eqIdx));
        int[] r = evaluate(equation.substring(eqIdx + 1, equation.length()));
        int[] result = {l[0] - r[0], (l[1] - r[1]) * -1};
        if (result[0] == 0 && result[1] == 0)
            return "Infinite solutions";
        double ans = (double) result[1] / result[0];
        return "x=" + (ans % 1 == 0 ? String.valueOf((int) ans) : ans);
    }

    public static int[] evaluate(String str) {
        List<String> splits = new ArrayList<>();
        String t = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                if (t.length() > 0)
                    splits.add(t);
                t = String.valueOf(c);
            } else {
                t += String.valueOf(c);
            }
        }
        splits.add(t);
        int coeff = 0, constant = 0;
        for (String s : splits) {
            if (s.indexOf("x") < 0) {
                constant += Integer.parseInt(s);
            } else {
                String tmp = s.substring(0, s.indexOf("x"));
                tmp = tmp.equals("") || tmp.equals("+") ? "1" : 
                      tmp.equals("-") ? "-1" : tmp;
                coeff += Integer.parseInt(tmp);
            }
        }
        return new int[]{coeff, constant};
    }

    // # 2 정규표현식 사용
    public static int[] evaluate2(String str) {
        int coeff = 0, constant = 0;
        for (String s : str.split("(?=[+-])"))
            if (s.indexOf("x") < 0)
                constant += Integer.parseInt(s);
            else {
                String tmp = s.substring(0, s.indexOf("x"));
                tmp = tmp.equals("") || tmp.equals("+") ? "1" : 
                      tmp.equals("-") ? "-1" : tmp;
                coeff += Integer.parseInt(tmp);
            }
        return new int[]{coeff, constant};
    }

    public static void main(String[] args) {
        // Test code
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solution(equation));

        equation = "x=x";
        System.out.println(solution(equation));

        equation = "2x=x";
        System.out.println(solution(equation));

        equation = "2x-6x+5-6=x+7-2-x";  
        System.out.println(solution(equation));  // x = -1.5

        equation = "-10+2x-x+5+8=3x+10-7-x+2x-4x";
        System.out.println(solution(equation));

        equation = "2x-2x+4=3-3+4";
        System.out.println(solution(equation));

        equation = "-3x-5=7-2x+4x";  
        System.out.println(solution(equation));  // x = -2.4

        equation = "x+4=135-x";
        System.out.println(solution(equation));  // x = 65.5
    }
}
