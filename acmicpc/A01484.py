def solution(g):
    ans = []
    prev = actual = 1
    while not ((diff := actual**2 - prev**2) > g and actual == prev + 1):
        actual += diff < g
        prev += diff >= g
        if diff == g:
            ans.append(actual)
    return '\n'.join(map(str, ans)) if ans else -1


def reader():
    print(solution(int(input())))


if __name__ == '__main__':
    reader()
