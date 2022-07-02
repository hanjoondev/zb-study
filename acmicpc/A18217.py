from sys import stdin
from collections import deque as dq


def reader():
    st, memo, ans = [], dq([0]), 0
    for c in stdin.readline().rstrip():
        if c in '()':
            st.append(('*' if c == ')' and len(memo) <= 1 else c, memo[-1]))
            if c == '(':
                memo[-1] += 1
                memo.append(0)
            elif len(memo) > 1:
                ans += memo[-2]
                memo.pop()
            else:
                memo[-1] = 0
        elif st and c == '-':
            char, m = st.pop()
            if char == '(':
                memo[-2] -= 1
                memo.pop()
            elif char == ')':
                ans -= memo[-1]
                memo.append(m)
            elif char == '*':
                memo[-1] = m
        print(ans)


if __name__ == '__main__':
    reader()
