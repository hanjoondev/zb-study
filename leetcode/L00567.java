package leetcode;

public class L00567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2)
            return false;
        int[] c1 = new int[26], c2 = new int[26];
        for (int i = 0; i < len1; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        int charCountMatched = 0;
        for (int i = 0; i < 26; i++)
            if (c1[i] == c2[i])
                charCountMatched++;
        for (int i = 0; i < len2 - len1; i++) {
            int l = s2.charAt(i) - 'a', r = s2.charAt(len1 + i) - 'a';
            if (charCountMatched == 26)
                return true;
            c2[l]--;
            charCountMatched += c1[l] == c2[l] ? 1 : c1[l] - 1 == c2[l] ? -1 : 0;
            c2[r]++;
            charCountMatched += c1[r] == c2[r] ? 1 : c1[r] + 1 == c2[r] ? -1 : 0;
        }
        return charCountMatched == 26;
    }
}
