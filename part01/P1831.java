public class P1831 {
    public static void solution(int[] nums) {
        int last = nums[0], biggest = nums[nums.length - 1];
        System.out.printf("%d" + (last < biggest ? ", " : ""), last);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                System.out.printf("%d" + (nums[i] < biggest ? ", " : "\n"), nums[i]);
                last = nums[i];
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
