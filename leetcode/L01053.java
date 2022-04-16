package leetcode;

public class L01053 {
    public int[] prevPermOpt1(int[] arr) {
        int bigger = arr.length - 2;
        if (bigger < 0 || bigger == 0 && arr[0] == arr[1])
            return arr;
        int smaller = bigger + 1;
        for (; bigger >= 0; bigger--)
            if (arr[bigger] > arr[bigger + 1])
                break;
        if (bigger < 0)
            return arr;
        while (smaller >= 0 && arr[smaller] >= arr[bigger])
            smaller--;
        while (smaller >= 0 && arr[smaller - 1] == arr[smaller])
            smaller--;
        int temp = arr[smaller];
        arr[smaller] = arr[bigger];
        arr[bigger] = temp;
        return arr;
    }
}
