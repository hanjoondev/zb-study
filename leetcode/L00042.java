package leetcode;

public class L00042 {
    public int trap(int[] h) {
        int area = 0, lmax = 0, rmax = 0, l = 0, r = h.length - 1;
        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] > lmax)
                    lmax = h[l];
                else
                    area += lmax - h[l];
                l++;
            } else {
                if (h[r] > rmax)
                    rmax = h[r];
                else
                    area += rmax - h[r];
                r--;
            }
        }
        return area;
    }
}
