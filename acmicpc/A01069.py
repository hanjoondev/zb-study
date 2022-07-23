from sys import stdin


def reader():
    read = stdin.readline
    x, y, d, t = map(int, read().split())
    q, r = divmod(dist := (x**2 + y**2)**0.5, d)
    print(min([dist, q * t + r, (q + 1) * d - dist + (q + 1) * t,
          (q + 1) * t if q else t * 2.0 if dist < d else float('inf')]))


if __name__ == '__main__':
    reader()
