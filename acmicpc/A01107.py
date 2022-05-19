from collections import deque as dq
from sys import stdin


def solution(target: int, length: int, broken: list[int]) -> int:
    if length == 10 or target == 100:
        return abs(target - 100)
    if not length:
        return min(abs(target - 100), len(str(target)))
    length = len(str(target))
    available = [str(i) for i in range(10) if i not in broken]
    ans = abs(target - 100)
    q = dq()
    for a in available:
        q.append(a)
    while q:
        tmp = q.pop()
        ans = min(ans, abs(target - int(tmp)) + (len_t := len(tmp)))
        if len_t < length or len_t == length and tmp.startswith('1'):
            for a in available:
                q.append(tmp + a)
    return ans


def reader():
    read = stdin.readline
    t = int(read().strip())
    b = list(map(int, read().split())) if (l := int(read().strip())) else []
    print(solution(t, l, b))


if __name__ == '__main__':
    reader()
