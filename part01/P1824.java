public class P1824 {
    public static String solution(int[] keyLog) {
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;
        String ans = "";
        char[] sym = {')', '!', '@', '#', '$', '%', '^', '&', '*', '('};
        int cur = 0;
        Boolean caps = false, shift = false, insert = false;
        for (int k : keyLog) {
            if (k == CAPS_LOCK) {
                caps = caps ? false : true;
            } else if (k == INSERT) {
                insert = insert ? false : true;
            } else if (k == KEY_LEFT && cur > 0) {
                cur--;
            } else if (k == KEY_RIGHT && cur <= ans.length()) {
                cur++;
            } else if (k == SPACE_BAR) {
                ans = ans.substring(0, cur) + " " + ans.substring(cur, ans.length());
                cur++;
            } else if (k == BACK_SPACE) {
                ans = ans.substring(0, cur > 0 ? cur - 1 : 0) + ans.substring(cur, ans.length());
                cur--;
            } else if (97 <= k && k <= 122) {
                String tmp = Character.toString(shift && caps || !shift && !caps ? k : k - 32);
                ans = ans.substring(0, cur) + tmp + ans.substring(insert ? cur + 1 : cur, ans.length());
                cur++;
            } else if (48 <= k && k <= 57) {
                String tmp = Character.toString(!shift ? k : sym[k - 48]);
                ans = ans.substring(0, cur) + tmp + ans.substring(insert ? cur + 1 : cur, ans.length());
                cur++;
            } else if (k == DELETE) {
                ans = ans.substring(0, cur) + ans.substring(cur + 1, ans.length());
            }
            if (k == SHIFT)
                shift = true;
            else
                shift = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test code
        int[] keyLog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97};
        System.out.println(solution(keyLog));

        keyLog = new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        System.out.println(solution(keyLog));
    }
}
