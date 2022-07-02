from re import findall as fa
from sys import stdin


def solution(s: str) -> str:
    if len(fa(r'[+\-*/]', s)) + 1 != len(fa(r'\d+', s)):
        return 'ROCK'
    try:
        return eval(s.replace('/', '//'))
    except (SyntaxError, ZeroDivisionError, TypeError, NameError):
        return 'ROCK'


def reader():
    read = stdin.readline
    print(solution(read().rstrip()))


if __name__ == '__main__':
    reader()
