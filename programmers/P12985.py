def solution(n, a, b):
    answer = 0
    while a != b:
        b = b // 2 + 1 if b % 2 else b // 2
        a = a // 2 + 1 if a % 2 else a // 2
        answer += 1
    return answer
