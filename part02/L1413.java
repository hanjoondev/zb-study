public class L1413 {
    public static void solution(int[] data) {
        int len = data.length, remaining = data.length - 1, nxt = data[0];
        int cur = 0, dir = nxt > 0 ? 1 : -1;
        int[] popped = new int[len];
        popped[cur] = 1;
        System.out.printf("%d ", cur + 1);
        while (remaining > 0) {
            int moveCount = 0;
            while (moveCount < Math.abs(nxt)) {
                cur += dir;
                cur = cur == len ? 0 : cur < 0 ? len - 1 : cur;
                moveCount += popped[cur] == 0 ? 1 : 0;
            }
            popped[cur] = 1;
            System.out.printf("%d ", cur + 1);
            nxt = data[cur];
            dir = nxt > 0 ? 1 : -1;
            remaining--;
        }
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
