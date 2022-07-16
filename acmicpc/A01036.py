from sys import stdin


def solution(words: list[str], k: int) -> str:
    def convert(n: int) -> str:
        res = ''
        while not res or n > 0:
            n, i = divmod(n, 36)
            res = d[i] + res
        return res

    d = {i: c for i, c in enumerate('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ')}
    e = {c: 0 for c in '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'}
    for word in words:
        for i, c in enumerate(word[::-1]):
            e[c] += 36 ** i
    for c, _ in sorted(sorted(
            {k: v * (35 - int(k, 36)) for k, v in e.items()}.items()),
            key=lambda x: -x[1])[:k]:
        for i in range(len(words)):
            words[i] = words[i].replace(c, 'Z')
    return convert(sum(int(w, 36) for w in words))


def reader():
    read = stdin.readline
    n = int(read())
    words = [read().rstrip() for _ in range(n)]
    k = int(read())
    print(solution(words, k))


if __name__ == '__main__':
    reader()
