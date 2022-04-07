import java.util.Arrays;

public class L1424 {
    public static String solution(String[] p, String[] c) {
        Arrays.sort(p);
        Arrays.sort(c);
        int i = 0, len = c.length;
        for (; i < len; i++)
            if (!p[i].equals(c[i]))
                return p[i];
        return p[i];
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
