def solution(n):
    ans = 0 if n >= 1 else 2  # overspec'd (negative integers)
    n = n if n > 0 else -n    # same as above
    while n != 1:
        ans += 1
        q, r = divmod(n, 2)
        n -= q if not r else r
    return ans


if __name__ == '__main__':
    tests = (
        (8, 3),
        (7, 4),
        (9, 4),
        (6, 3),
        (-5, 5)  # the overspec question
    )
    for num, expected in tests:
        actual = solution(num)
        print(f'solution({num}) -> {actual} '
              f'({"correct" if actual == expected else "incorrect"})')
