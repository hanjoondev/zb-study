from collections import deque as dq
from sys import stdin as s


def find_rtp(num_digits: int) -> None:
    seeds = '2 3 5 7'.split()
    if num_digits == 1:
        print('\n'.join(seeds))
        return
    q = dq()
    for seed in seeds:
        q.append(seed)
    for _ in range(num_digits - 1):
        nq = dq()
        while q:
            seed = q.popleft()
            for s in '13579':
                if is_prime(int(cand := seed + s)):
                    nq.append(cand)
        q = nq
    print('\n'.join(q))


def is_prime(n):
    if n < 10:
        return n in (2, 3, 5, 7)
    if not n % 2:
        return False
    for i in range(3, int(n**0.5) + 1, 2):
        if not n % i:
            return False
    return True


def reader():
    find_rtp(int(s.readline().strip()))


if __name__ == '__main__':
    reader()
