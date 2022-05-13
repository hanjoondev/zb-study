def solution(s):
    if not s:
        return None
    length = len(s)
    left, right = 0, length - 1
    while left < right and (c := s[left]) == s[right]:
        while left <= right and s[left] == c:
            left += 1
        while left <= right and s[right] == c:
            right -= 1
    return s[left:right + 1] if right >= left else None


if __name__ == '__main__':
    tests = [
        ("ab", "ab"),
        ("aaabbaa", None),
        ("aaabcbaa", "c"),
    ]
    for s, expected in tests:
        actual = solution(s)
        print(f'solution({s}) -> {actual} '
              f'({"correct" if actual == expected else "incorrect"})')
