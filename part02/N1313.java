import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class N1313Mail {
    int[] parent;
    public N1313Mail(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++)
            this.parent[i] = i;
    }

    public int find(int idx) {
        if (this.parent[idx] != idx)
            this.parent[idx] = this.find(this.parent[idx]);
        return this.parent[idx];
    }

    public void union(int parent, int child) {
        this.parent[this.find(child)] = this.find(parent);
    }
}

public class N1313 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        int len = accounts.size();
        N1313Mail p = new N1313Mail(len);
        HashMap<String, Integer> mMap = new HashMap<>();
        HashMap<Integer, List<String>> pMap = new HashMap<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++)
                if (mMap.containsKey(accounts.get(i).get(j)))
                    p.union(mMap.get(accounts.get(i).get(j)), i);
                else
                    mMap.put(accounts.get(i).get(j), i);
        }
        for (String mail : mMap.keySet()) {
            int root = p.find(mMap.get(mail));
            List<String> mails = pMap.getOrDefault(root, new ArrayList<String>());
            mails.add(mail);
            pMap.put(root, mails);
        }
        for (int k : pMap.keySet()) {
            List<String> name = Arrays.asList(accounts.get(k).get(0)), mails = pMap.get(k);
            Collections.sort(mails);
            ans.add((ArrayList<String>) Stream.concat(name.stream(), mails.stream())
                                              .collect(Collectors.toList()));
        }
        return ans;
    }

/* leetcode submission
    // Source: 721. Accounts Merge https://leetcode.com/problems/accounts-merge/
    // Submission detail: https://leetcode.com/submissions/detail/678394908/
    //     Runtime: 26 ms, faster than 96.50% of Java online submissions for Accounts Merge.
    //     Memory Usage: 45.8 MB, less than 97.52% of Java online submissions for Accounts Merge.
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Mail {
    int[] parent;
    public Mail(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++)
            this.parent[i] = i;
    }

    public int find(int idx) {
        if (this.parent[idx] != idx)
            this.parent[idx] = this.find(this.parent[idx]);
        return this.parent[idx];
    }

    public void union(int parent, int child) {
        this.parent[this.find(child)] = this.find(parent);
    }
}

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        Mail p = new Mail(len);
        HashMap<String, Integer> mMap = new HashMap<>();
        HashMap<Integer, List<String>> pMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++)
                if (mMap.containsKey(accounts.get(i).get(j)))
                    p.union(mMap.get(accounts.get(i).get(j)), i);
                else
                    mMap.put(accounts.get(i).get(j), i);
        }
        for (String mail : mMap.keySet()) {
            int root = p.find(mMap.get(mail));
            List<String> mails = pMap.getOrDefault(root, new ArrayList<String>());
            mails.add(mail);
            pMap.put(root, mails);
        }
        for (int k : pMap.keySet()) {
            List<String> name = Arrays.asList(accounts.get(k).get(0)), mails = pMap.get(k);
            Collections.sort(mails);
            ans.add(Stream.concat(name.stream(), mails.stream()).collect(Collectors.toList()));
        }
        return ans;
    }
}
*/

    public static void main(String[] args) {
        // Test code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        for (ArrayList<String> person : solution(accounts))
            System.out.println(person);
    }
}
