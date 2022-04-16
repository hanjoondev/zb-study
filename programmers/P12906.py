def solution(arr):
    if not arr or len(arr) == 1:
        return arr
    answer = [arr[0]]
    prev = arr[0]
    for i, n in enumerate(arr[1:]):
        if prev == n:
            continue
        answer.append(n)
        prev = n
    return answer
