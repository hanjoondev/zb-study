package leetcode;

import java.util.*;

public class L00640 {
    public String solveEquation(String equation) {
        int eqIdx = equation.indexOf("=");
        int[] l = evaluate(equation.substring(0, eqIdx));
        int[] r = evaluate(equation.substring(eqIdx + 1, equation.length()));
        int[] result = {l[0] - r[0], (l[1] - r[1]) * -1};
        if (result[0] == 0 && result[1] == 0)
            return "Infinite solutions";
        if (result[0] == 0)
            return "No solution";
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
}
