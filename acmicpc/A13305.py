from sys import stdin


def greedy(price: list[int], dist: list[int], length: int) -> int:
    prev, cost = price[0], price[0] * dist[0]
    for p, d in zip(price[1:], dist[1:] + [0]):
        cost += (prev := min(prev, p)) * d
    return cost


def reader():
    readline = stdin.readline
    n = int(readline().strip())
    dist = list(map(int, readline().split()))
    price = list(map(int, readline().split()))
    print(greedy(price, dist, n))


if __name__ == '__main__':
    reader()
