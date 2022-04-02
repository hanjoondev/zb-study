public class P1811 {
    public static int solution(int n) {
        return n < 0 ? -solution(-n) : Integer.parseInt(new StringBuilder().append(n).reverse().toString());
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(12345));
        System.out.println(solution(-12345));
        System.out.println(solution(100));
        System.out.println(solution(0));
    }
}
