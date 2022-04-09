import java.util.Arrays;
import java.util.stream.Collectors;

public class M0912 {
    public static void solution(int[] arr) {
        int bigger = arr.length - 2;
        if (bigger < 0 || bigger == 0 && arr[0] == arr[1]) {
            System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
            return;
        }
        int smaller = bigger + 1;
        for (; bigger >= 0; bigger--)
            if (arr[bigger] > arr[bigger + 1])
                break;
        if (bigger < 0) {
            System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
            return;
        }
        while (smaller >= 0 && arr[smaller] >= arr[bigger])
            smaller--;
        while (smaller >= 0 && arr[smaller - 1] == arr[smaller])
            smaller--;
        int temp = arr[smaller];
        arr[smaller] = arr[bigger];
        arr[bigger] = temp;
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

/* leetcode submission
    // Source: 1053. Previous Permutation With One Swap https://leetcode.com/problems/previous-permutation-with-one-swap/
    // Submission detail: https://leetcode.com/submissions/detail/676648044/
    //     Runtime: 0 ms, faster than 100.00% of Java online submissions for Previous Permutation With One Swap.
    //     Memory Usage: 43.9 MB, less than 82.95% of Java online submissions for Previous Permutation With One Swap.
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
*/

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}
