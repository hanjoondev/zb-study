import java.util.Arrays;
import java.util.stream.Collectors;

public class M0912 {
    public static void solution(int[] arr) {
        int len = arr.length;
        int bigger = len - 1, smaller = len - 1;
        Boolean found = false;
        while (smaller > 0 && !found) {
            for (int i = smaller - 1; i >= 0; i--) {
                if (arr[i] > arr[smaller]) {
                    bigger = i;
                    found = true;
                    break;
                }
            }
            smaller -= found ? 0 : 1;
        }
        if (found) {
            int temp = arr[smaller];
            arr[smaller] = arr[bigger];
            arr[bigger] = temp;
        }
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

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
