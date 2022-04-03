import java.util.stream.IntStream;

public class P1814 {
    public static void solution(int n, int type) {
        switch (type) {
            case 1: type1(n);
                    break;
            case 2: type2(n);
                    break;
            case 3: type3(n);
                    break;
            case 4: type4(n);
                    break;
            case 5: type5(n);
                    break;
        }
    }

    public static void type1(int n) {
        System.out.println("== Type1 ==");
        "*".repeat(n).chars().forEachOrdered(i -> System.out.println("*".repeat(n)));
        System.out.println();
    }

    public static void type2(int n) {
        System.out.println("== Type2 ==");
        IntStream.range(1, n + 1).forEach(i -> System.out.println("*".repeat(i)));
        System.out.println();
    }

    public static void type3(int n) {
        System.out.println("== Type3 ==");
        IntStream.range(1, n + 1).forEach(i -> System.out.printf("%s%s\n", " ".repeat(n - i), "*".repeat(i)));
        System.out.println();
    }

    public static void type4(int n) {
        System.out.println("== Type4 ==");
        IntStream.range(0, n).forEach(i -> System.out.printf("%s%s%s\n", " ".repeat(n - i - 1), "*".repeat(i + 1), "*".repeat(i)));
        System.out.println();
    }

    public static void type5(int n) {
        System.out.println("== Type5 ==");
        IntStream.range(0, (int) Math.ceil(n / 2) + 1).forEach(i -> System.out.printf("%s%s\n", " ".repeat((int) Math.round(n / 2) - i), "*".repeat(2 * i + 1)));
        IntStream.range(0, (int) Math.ceil(n / 2)).forEach(i -> System.out.printf("%s%s\n", " ".repeat(i + 1), "*".repeat(n - 2 * (i + 1))));
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 1);
        solution(3, 2);
        solution(3, 3);
        solution(3, 4);
        solution(7, 5);
    }
}
