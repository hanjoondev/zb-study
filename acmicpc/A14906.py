from re import match
from sys import stdin


def slimp(s: str) -> bool:
    if len(s) > 2:
        if match("(AB.+C)", s):
            return slimp(s[2:-1])
        return match("(A.+C)", s) and match("^([DE]F+)+G$", s[1:-1])
    return s == 'AH'


def reader():
    read = stdin.readline
    ans = ['SLURPYS OUTPUT']
    for _ in range(int(read().rstrip())):
        s = read().rstrip()
        c = (r := len(s)) - s[::-1].find('C')
        b, y, n = c < (r := r + 1), 'YES', 'NO'
        ans.append(y if match("^([DE]F+)+G$", s[c if b else 2:])
                   and (slimp(s[:c]) if b else s.startswith('AH')) else n)
    print('\n'.join(ans) + '\nEND OF OUTPUT')


if __name__ == '__main__':
    reader()
