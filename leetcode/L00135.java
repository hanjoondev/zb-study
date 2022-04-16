package leetcode;

public class L00135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] fToR = new int[len], rToF = new int[len];
        fToR[0] = 1;
        rToF[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            fToR[i] = ratings[i] > ratings[i - 1] ? fToR[i - 1] + 1 : 1;
            rToF[len - i - 1] = ratings[len - i - 1] > ratings[len - i] ? rToF[len - i] + 1 : 1;
        }
        int ans = 0;
        for (int i = 0; i < len; i++)
            ans += Math.max(fToR[i], rToF[i]);
        return ans;
    }
}
