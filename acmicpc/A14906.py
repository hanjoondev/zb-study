from re import match
from sys import stdin


def slimp(s: str) -> bool:
    if len(s) > 2:
        if match(r'(AB.+C)', s):
            return slimp(s[2:-1])
        return match(r'(A.+C)', s) and match(r'^([DE]F+)+G$', s[1:-1])
    return s == 'AH'


def reader():
    read = stdin.readline
    ans, p = ['SLURPYS OUTPUT'], r'^([DE]F+)+G$'
    for _ in range(int(read().rstrip())):
        s = read().rstrip()
        ans.append('YES' if match(p, s[c if (c := s.rfind('C') + 1) else 2:])
                   and (slimp(s[:c]) if c else s.startswith('AH')) else 'NO')
    print('\n'.join(ans) + '\nEND OF OUTPUT')


if __name__ == '__main__':
    reader()
