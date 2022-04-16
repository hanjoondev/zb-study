package leetcode;

import java.util.*;

public class L00658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l + 1 > k)
            if (Math.abs(x - arr[l]) > Math.abs(x - arr[r]))
                l++;
            else
                r--;
        return Arrays.stream(arr).boxed().toList().subList(l, r + 1);
    }
}
