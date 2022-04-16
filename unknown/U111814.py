def solution(r, t):
    print(f'\nType: {t}')
    s = ('\n'.join('*' * r for _ in range(r)) if t == 1 
        else '\n'.join('*' * i for i in range(1, r + 1)) if t == 2
        else '\n'.join(('*' * i).rjust(r) for i in range(1, r + 1)) if t == 3
        else '\n'.join(('*' * (2 * i + 1)).center(r * 2) for i in range(r)) if t == 4
        else '\n'.join((u := [('*' * (2 * i + 1)).center(r + 1) for i in range(r // 2 + 1)])
                    + u[::-1][1:]) if t == 5 else '')
    print(s)

if __name__ == '__main__':
    solution(3, 1);
    solution(3, 2);
    solution(3, 3);
    solution(3, 4);
    solution(7, 5);
