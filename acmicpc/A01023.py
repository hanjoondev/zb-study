from sys import stdin


def solution(n: int, k: int) -> str:
    if n & 1:
        return ''.join(')' if 1 << i & k else '('
                       for i in range(n - 1, -1, -1))
    dp = [[1] * 51] + [[0] * 51 for _ in range(50)]
    for i in range(n):
        for j in range(1, i + 1):
            dp[j][i] = dp[j - 1][i] + dp[j][i - 1]
    if dp[a := n // 2][n // 2] + k >= 1 << n:
        return '-1'
    ans, b, c = [], a, 0
    for i in range(n - 1, -1, -1):
        tmp = 1 << i
        if c:
            ans.append('(' if k < tmp else ')')
            k -= tmp * (k >= tmp)
            continue
        if k < (tmp := tmp - dp[a - 1][b]):
            ans.append('(')
            if not (a := a - 1):
                c = 1
        else:
            ans.append(')')
            k -= tmp
            if a > (b := b - 1):
                c = 1
    return ''.join(ans)


def reader():
    read = stdin.readline
    n, k = map(int, read().split())
    print(solution(n, k))


if __name__ == '__main__':
    reader()
