import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
        ArrayList<ArrayList<Integer>> possibles = new ArrayList<ArrayList<Integer>>();
        int numTypes = set.size(), last = gems.length - 1;
        int l = 0, r = numTypes - 1;
        for (int i = 0; i < numTypes; i++)
            addSub(gems[i], null, count);
        while (l != last) {
            if (count.size() == numTypes) {
                possibles.add(Stream.of(new Integer[] {r - l, l + 1, r + 1})
                                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
                addSub(null, gems[l], count);
                l++;
            } else if (r != last) {
                addSub(gems[r + 1], null, count);
                r++;
            } else if (r - l <= numTypes)
                break;
        }
        Collections.sort(possibles, new Comparator<ArrayList<Integer>>() {    
            @Override
            public int compare(ArrayList<Integer> al1, ArrayList<Integer> al2) {
                return al1.get(0).compareTo(al2.get(0));
            }               
        });
        return IntStream.of(possibles.get(0).get(1), possibles.get(0).get(2))
                        .boxed().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
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
