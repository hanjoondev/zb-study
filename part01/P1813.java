public class P1813 {
    public static String solution(char[] str, char[] find, char[] to) {
        String ans = "";
        int sLen = str.length, fLen = find.length, tLen = to.length;
        for (int i = 0; i < sLen; i++) {
            if (str[i] == find[0] && i + fLen <= sLen) {
                Boolean isEqual = true;
                for (int j = 0; j < fLen; j++) {
                    if (str[i + j] != find[j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    for (int j = 0; j < tLen; j++)
                        ans += to[j];
                    i += fLen - 1;
                } else {
                    ans += str[i];
                }
            } else {
                ans += str[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}
