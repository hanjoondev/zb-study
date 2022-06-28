from sys import stdin


def solution(capitals: list[int], length: int) -> str:
    ans, sum_ = 0, sum(capitals)
    capitals += capitals
    for i in range(length):
        subsum = 0
        for j in range(i, i + length):
            subsum += capitals[j]
            if subsum < 0:
                ans += (-subsum - 1) // sum_ + 1
    return ans


def reader():
    read = stdin.readline
    n = int(read().strip())
    print(solution(list(map(int, read().split())), n))


if __name__ == '__main__':
    reader()
