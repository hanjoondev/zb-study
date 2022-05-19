from sys import stdin


def solution(n: str) -> str:
    num = int(n)
    if len(n) == 1:
        return ' '.join(map(str, [0] + [1] * num + [0] * (9 - num)))
    d, s, digit = {i: 0 for i in range(10)}, 1, 1
    while s <= num:
        while s <= num and num % 10 != 9:
            for c in str(num):
                d[int(c)] += digit
            num -= 1
        if s > num:
            break
        while s <= num and s % 10:
            for c in str(s):
                d[int(c)] += digit
            s += 1
        s, num = s // 10, num // 10
        for i in range(10):
            d[i] += digit * (num - s + 1)
        digit *= 10
    return ' '.join(map(str, [v for v in d.values()]))


def reader():
    print(solution(stdin.readline().strip()))


if __name__ == '__main__':
    reader()
