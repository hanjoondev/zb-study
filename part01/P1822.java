public class P1822 {

    public static String solution(int num){
        String result = "", d = "IVXLCDM";
        for (int i = 1; i < 6; i += 2) {
            int q = num % 10 / 5;
            int r = num % 10 % 5;
            num /= 10;
            if (r < 4)
                result += String.valueOf(d.charAt(i - 1)).repeat(r) + String.valueOf(d.charAt(i)).repeat(q);
            else
                result += String.valueOf(d.charAt(i + q)) + String.valueOf(d.charAt(i - 1));
        }
        result += String.valueOf(d.charAt(d.length() - 1)).repeat(num);
        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(13));
        System.out.println(solution(26));
        System.out.println(solution(1994));
    }
}
