package leetcode;

public class L00020 {
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
}
