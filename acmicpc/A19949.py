from sys import stdin as s


def solution(a: list[int]) -> None:
    def bt(i: int=0, pp: int=0, p: int=0, hit: int=0,
        memo=[[[[0] * 11 for _ in range(6)] for _ in range(6)]
                                            for _ in range(11)]) -> int:
        if memo[i][pp][p][hit]:
            return memo[i][pp][p][hit]
        if i == 10:
            return hit >= 5
        for guess in range(1, 6):
            if pp == p == guess:
                continue
            memo[i][pp][p][hit] += (bt(i + 1, p, guess, hit + 1)
                if a[i] == guess else bt(i + 1, p, guess, hit))
        return memo[i][pp][p][hit]

    print(bt())


def reader():
    solution(list(map(int, s.readline().split())))


if __name__ == '__main__':
    reader()
