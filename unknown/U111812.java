package unknown;

import java.util.Scanner;

public class U111812 {
    public static void solution() {
        Scanner userInput = new Scanner(System.in);
        System.out.printf("Enter any string: ");
        String s = userInput.nextLine();
        userInput.close();
        System.out.println(s.chars().map(c -> Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c))
                                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
    }

    public static void reference() {
        System.out.println("a = " + (int) 'a');
        System.out.println("z = " + (int) 'z');
        System.out.println("A = " + (int) 'A');
        System.out.println("Z = " + (int) 'Z');
        System.out.println("% = " + (int) '%');
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}
