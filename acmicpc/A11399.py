from sys import stdin


def greedy(times: list[int]) -> int:
    times.sort()
    ans = cumulative = times[0]
    for t in times[1:]:
        ans, cumulative = ans + cumulative + t, cumulative + t
    return ans


def reader():
    readline = stdin.readline
    readline()
    print(greedy(list(map(int, readline().split()))))


if __name__ == '__main__':
    reader()
