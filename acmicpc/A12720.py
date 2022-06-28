from sys import stdin
from bisect import bisect_left as bl, bisect_right as br
from collections import deque as dq
from itertools import islice


class UF(object):
    def __init__(self, length):
        self.children = [i for i in range(length)]
        self.count = length

    def find(self, k):
        q = dq()
        while self.children[k] != k:
            q.append(k)
            k = self.children[k]
        for c in q:
            self.children[c] = k
        return k

    def union_set(self, a, b):
        if (a := self.find(a)) != (b := self.find(b)):
            self.children[min(a, b)] = max(a, b)
            self.count -= 1


def get_primes(n):
    if n < 5:
        return [i for i in range(n) if i in (2, 3)]
    n, c = n + 6 - n % 6, 2 - (n % 6 > 1)
    sieve = [True] * (n // 3)
    for i in range(1, int(n**0.5) // 3 + 1):
        if sieve[i]:
            d, s, j = (k := 1 | 3*i + 1) * 2, k * k, k * (k + 4 - 2 * (i & 1))
            sieve[s // 3::d] = [False] * ((n//6 - s//6 - 1) // k + 1)
            sieve[j // 3::d] = [False] * ((n//6 - j//6 - 1) // k + 1)
    return [2, 3] + [1 | 3 * i + 1 for i in range(1, n // 3 - c) if sieve[i]]


def solution(primes: list[int], a: int, b: int, p: int) -> str:
    uf = UF(b + 1 - a)
    for prime in islice(primes, bl(primes, p), br(primes, b - a)):
        l, r = ((a - 1) // prime + 1) * prime, b // prime * prime
        for i in range(l, r + 1, prime):
            uf.union_set(l - a, i - a)
    return str(uf.count)


def reader():
    read = stdin.readline
    primes = get_primes(10**6)
    c, ans = int(read().strip()), []
    for i in range(c):
        a, b, p = map(int, read().split())
        ans.append(f'Case #{i + 1}: {solution(primes, a, b, p)}')
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
