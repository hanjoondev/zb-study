package leetcode;

import java.util.*;
import java.util.stream.*;

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

public class L00721 {
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
