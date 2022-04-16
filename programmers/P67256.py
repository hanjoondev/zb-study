def solution(numbers, hand):
    answer, l, r  = '', 10, 12
    for n in (n if n else 11 for n in numbers):
        if (remainder := n % 3) == 1:
            answer, l = answer + 'L', n
            continue
        elif not remainder:
            answer, r = answer + 'R', n
            continue
        ldist, rdist = sum(divmod(abs(l - n), 3)), sum(divmod(abs(r - n), 3))
        h = hand[0].upper() if ldist == rdist else 'LR'[1 * (ldist > rdist)]
        l, r = n if h == 'L' else l, n if h == 'R' else r
        answer += h
    return answer
