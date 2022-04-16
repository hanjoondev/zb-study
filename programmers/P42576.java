package programmers;

import java.util.Arrays;

class P42576 {
    public String solution(String[] p, String[] c) {
        Arrays.sort(p);
        Arrays.sort(c);
        int i = 0, len = c.length;
        for (; i < len; i++)
            if (!p[i].equals(c[i]))
                return p[i];
        return p[i];
    }

    public static void main(String[] args) {
        System.out.println(new P42576().solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(new P42576().solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(new P42576().solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }
}
