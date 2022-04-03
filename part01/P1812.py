def solution(c):
    return c.swapcase()


if __name__ == '__main__':
    for c in 'a b C D'.split():
        print(solution(c))
