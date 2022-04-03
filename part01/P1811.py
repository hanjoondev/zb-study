def solution(n):
    return -solution(-n) if n < 0 else int(str(n)[::-1])


if __name__ == '__main__':
    for n in (12345, -12345, 100, 0):
        print(solution(n))
