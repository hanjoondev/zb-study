from sys import stdin
from functools import cmp_to_key


def compare(a, b):
    return 1 if a + b < b + a else -1 if a + b > b + a else 0


def reader():
    read = stdin.readline
    k, n = map(int, read().split())
    ans, lgst = [], ''
    for _ in range(k):
        ans.append(cur := read().rstrip())
        if len(cur) > len(lgst) or len(cur) == len(lgst) and cur > lgst:
            lgst = cur
    ans += [lgst] * (n - k)
    print(''.join(sorted(ans, key=cmp_to_key(compare))))


if __name__ == '__main__':
    reader()
