from re import fullmatch as m
from sys import stdin


def reader():
    read = stdin.readline
    print('SUBMARINE' if m('(100+1+|01)+', read().rstrip()) else 'NOISE')


if __name__ == '__main__':
    reader()
