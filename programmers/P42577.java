package programmers;

public class P42577 {
    class Trie {
        Trie[] children;
        int numTotalChildren;

        public Trie() {
            this.children = new Trie[10];
        }

        public void insert(String phoneNumber) {
            Trie node = this;
            for (int i = 0; i < phoneNumber.length(); i++) {
                int digit = phoneNumber.charAt(i) - '0';
                if (node.children[digit] == null)
                    node.children[digit] = new Trie();
                node = node.children[digit];
                node.numTotalChildren++;
            }
        }

        public Trie startsWith(String phoneNumber) {
            Trie node = this;
            for (int i = 0; i < phoneNumber.length(); i++)
                node = node.children[phoneNumber.charAt(i) - '0'];
            return node;
        }

        public int getTotalChildren(String phoneNumber) {
            return this.startsWith(phoneNumber).numTotalChildren;
        }
    }

    public boolean solution(String[] phoneNumbers) {
        Trie trie = new Trie();
        for (String num : phoneNumbers)
            trie.insert(num);
        for (String num : phoneNumbers)
            if (trie.getTotalChildren(num) > 1)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P42577().solution(new String[] { "119", "97674223", "1195524421" }));
        System.out.println(new P42577().solution(new String[] { "123", "456", "789" }));
        System.out.println(new P42577().solution(new String[] { "12", "123", "1235", "567", "88" }));
    }
}
