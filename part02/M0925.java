public class M0925 {

    public static void solution(int n) {
        recurTowers(n, 1, 3, 2);
    }

    public static void recurTowers(int n, int fr, int to, int aux) {
        if (n == 1) {
            System.out.printf("%d %d\n", fr, to);
            return;
        } else {
            recurTowers(n - 1, fr, aux, to);
            recurTowers(1, fr, to, aux);
            recurTowers(n - 1, aux, to, fr);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
    }
}
