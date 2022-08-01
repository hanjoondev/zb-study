from sys import stdin


def solution(dna: str, ct: list[list[str]], n: int) -> int:
    ai = {a: i for i, a in enumerate('ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    dp, q = [1] + [0] * n, [[0] * 26 for _ in range(n)] + [[n + 1] * 26]
    for i in range(n - 1, -1, -1):
        q[i] = [num for num in q[i + 1]]
        q[i][ai[dna[i]]] = i + 1
    ans, c, a, kind, d = 0, [], [], 0, {}
    for codon, amino in ct:
        c.append(codon)
        if amino not in d:
            d[amino] = kind
            kind += 1
        a.append(d[amino])
    for i in range(n):
        indices = [n + 1] * kind
        for j, codon in enumerate(c):
            k = i
            for char in codon:
                if k <= n:
                    k = q[k][ai[char]]
            indices[a[j]] = min(indices[a[j]], k)
        for idx in indices:
            if idx <= n:
                dp[idx] = (dp[idx] + dp[i]) % 1_000_000_007
    ans = 0
    for i in range(1, n + 1):
        ans = (ans + dp[i]) % 1_000_000_007
    return ans


def reader():
    read = stdin.readline
    dna = read().rstrip()
    m = int(read())
    ct = [read().split() for _ in range(m)]
    print(solution(dna, ct, len(dna)))


if __name__ == '__main__':
    reader()
