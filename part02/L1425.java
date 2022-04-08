import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L1425 {
    public static void addSub(String add, String sub, HashMap<String, Integer> count) {
        if (add != null) {
            if (count.containsKey(add)) {
                int tmp = count.get(add);
                count.put(add, tmp + 1);
            } else {
                count.put(add, 1);
            }
        }
        if (sub != null) {
            int tmp = count.get(sub);
            if (tmp > 1)
                count.put(sub, tmp - 1);
            else
                count.remove(sub);
        }
    }

    public static ArrayList<Integer> solution(String[] gems) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(gems));
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        ArrayList<List<Integer>> possibles = new ArrayList<List<Integer>>();
        int numTypes = set.size(), last = gems.length - 1;
        int l = 0, r = numTypes - 1;
        for (int i = 0; i < numTypes; i++)
            addSub(gems[i], null, count);
        while (l != last) {
            if (count.size() == numTypes) {
                possibles.add(Stream.of(new Integer[] {r - l, l, r}).toList());
                addSub(null, gems[l], count);
                l++;
            } else if (r != last) {
                addSub(gems[r + 1], null, count);
                r++;
            } else if (r - l <= numTypes)
                break;
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> possible : possibles)
            if (possible.get(0) < min) {
                min = possible.get(0);
                l = possible.get(1) + 1;
                r = possible.get(2) + 1;
            }
        return IntStream.of(l, r).boxed().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void main(String[] args) {
        // Test code
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));
    }
}
