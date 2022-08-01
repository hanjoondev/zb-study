from sys import stdin


def reader():
    read = stdin.readline
    d, p, q = map(int, read().split())
    ans, p, q = float('inf'), max(p, q), min(p, q)
    for i in range(min(q, d // p + 2)):
        tmp = (d - p * i) // q
        ans = min(ans, min([r for j in range(max(0, tmp - 2), tmp + 2)
                            if (r := p * i + q * j) >= d] + [float('inf')]))
    print(ans)


if __name__ == '__main__':
    reader()
