from sys import stdin


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


def two_pointer(n: int) -> int:
    if not (primes := get_primes(n + 1)):
        return 0
    length = len(primes)
    primes += [0]
    slow = fast = sum_ = ans = 0
    while fast <= length:
        if sum_ < n:
            sum_ += primes[fast]
            fast += 1
        else:
            ans += sum_ == n
            sum_ -= primes[slow]
            slow += 1
    return ans


def reader():
    n = int(stdin.readline())
    print(two_pointer(n))


if __name__ == '__main__':
    reader()
