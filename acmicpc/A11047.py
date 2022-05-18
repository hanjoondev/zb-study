from sys import stdin


def greedy(coins: list[int], length: int, target: int) -> int:
    ans, i = 0, length - 1
    while target:
        q, r = divmod(target, coins[i])
        if q:
            ans += q
            target = r
        i -= 1
    return ans


def reader():
    n, k = map(int, stdin.readline().split())
    coins = [int(stdin.readline()) for _ in range(n)]
    print(greedy(coins, n, k))


if __name__ == '__main__':
    reader()
