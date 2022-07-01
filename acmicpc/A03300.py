from re import match, sub
from string import ascii_uppercase as caps
from sys import stdin


def reader():
    read = stdin.readline
    ans, us = [], '_'
    for _ in range(int(read().rstrip())):
        i, o = read().rstrip(), read().rstrip()
        m = [c for c in caps if match(f'^{sub(us, c, i)}$', o)]
        ans.append('!' if not m else m[0] if len(m) == 1 else us)
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
