from sys import stdin


def get_primes(n: int) -> set[int]:
    if n < 5:
        return set([i for i in range(n) if i in (2, 3)])
    n, c = n + 6 - n % 6, 2 - (n % 6 > 1)
    s = [True] * (n // 3)
    for i in range(1, int(n**0.5) // 3 + 1):
        if s[i]:
            d, h, j = (k := 1 | 3*i + 1) * 2, k * k, k * (k + 4 - 2 * (i & 1))
            s[h // 3::d] = [False] * ((n//6 - h//6 - 1) // k + 1)
            s[j // 3::d] = [False] * ((n//6 - j//6 - 1) // k + 1)
    return set([2, 3] + [1 | 3 * i + 1 for i in range(1, n // 3 - c) if s[i]])


def solution(nums: list[int]) -> str:
    def dfs(n):
        if v[n]:
            return False
        v[n] = True
        for no in tmp:
            if n + no in primes:
                if no not in matched or dfs(matched[no]):
                    matched[no] = n
                    return True
        return False

    first, len_ = nums[0], len(nums)
    if len_ & 1 or len([n for n in nums if n & 1]) * 2 != len_:
        return '-1'
    primes, ans = get_primes(2000), []
    cand = [n for n in nums[1:] if first + n in primes]
    if len(cand) == 1 and len_ == 2:
        return str(cand[0])
    for n in cand:
        matched = {}
        for num in (tmp := [num for num in nums[1:] if num != n]):
            v = {k: False for k in tmp}
            dfs(num)
        if len(matched) + 2 == len_:
            ans.append(n)
    return ' '.join(map(str, sorted(ans))) if ans else '-1'


def reader():
    read = stdin.readline
    _ = read()
    print(solution(list(map(int, read().split()))))


if __name__ == '__main__':
    reader()
