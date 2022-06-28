from sys import stdin


def calc(s: list[str, int], idx=0):
    for i, c in enumerate(s):
        if type(c) == str and c in '*+':
            idx = i
            break
    a = 2 - s[idx - 1] if (idx - 1) % 2 else s[idx - 1]
    b = 2 - s[-1] if (len(s) - idx - 2) % 2 else s[-1]
    if s[idx] == '*':
        return 0 if not a or not b else 1 + (a == b == 2)
    return 0 if a == b == 0 else 1 + (a == 2 or b == 2)


def evaluate(s: list[str, int], parentheses: int):
    while parentheses:
        start = end = -1
        for i, c in enumerate(s):
            if c == '(':
                start = i
                continue
            if c == ')' and start != -1:
                end = i
                break
        s[start] = calc(s[start + 1:end])
        del s[start + 1: end + 1]
        parentheses -= 1
    if (length := len(s)) > 1:
        return 2 - s[-1] if (length - 1) % 2 else s[-1]
    return s[0]


def solution(eq: str, perms: list[tuple[int]]) -> str:
    ans, paren, idx = 0, 0, {k: [] for k in 'PQR'}
    for i, c in enumerate(eq):
        if type(c) == int: continue
        if c == '(':
            paren += 1
        elif c in 'PQR': idx[c].append(i)
    for p, q, r in perms:
        s = [c for c in eq]
        for i in idx['P']: s[i] = p
        for i in idx['Q']: s[i] = q
        for i in idx['R']: s[i] = r
        ans += evaluate(s, paren) == 2
    return ans


def reader():
    eqs, perms = [], [(p, q, r)
        for p in range(3) for q in range(3) for r in range(3)]
    while (eq := stdin.readline().strip()) != '.':
        eqs.append(eq)
    for eq in eqs:
        if (length := len(eq)) == 1:
            try:
                print(27 if int(eq) == 2 else 0)
            except ValueError:
                print(9)
        elif '(' not in eq:
            p, odd = (c := eq[-1]) in 'PQR', length & 1
            print(9 if p else 27 * (c == '0' and not odd or c == '2' and odd))
        else:
            print(solution([int(c) if c in '012' else c for c in eq], perms))


if __name__ == '__main__':
    reader()
