from sys import stdin as s


def solution(answers: list[int]) -> None:
    def dfs_bt(pp: int=0, p: int=0, i: int=0, hit: int=0) -> None:
        if dfs_bt.len - i + hit < 5 or i == dfs_bt.len:
            dfs_bt.res += hit >= 5
            return None
        repeated = p if i > 1 and pp == p else None
        for guess in range(1, 6):
            if guess == repeated:
                continue
            dfs_bt(p, guess, i + 1, hit + (guess == answers[i]))

    dfs_bt.len, dfs_bt.res = len(answers), 0
    dfs_bt()
    print(dfs_bt.res)


def reader():
    solution(list(map(int, s.readline().split())))


if __name__ == '__main__':
    reader()
