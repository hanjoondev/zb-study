from sys import stdin


def reader():
    ans = n = int(stdin.readline().rstrip())
    i = 2
    while i * i <= n:
        if not n % i:
            ans -= ans // i
            while not n % i:
                n //= i
        i += 1
    print(ans if n <= 1 else ans - ans // n)


if __name__ == '__main__':
    reader()
