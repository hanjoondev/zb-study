from sys import stdin as s


def solution(seq: list[int], n: int) -> None:
    q = [seq[0]]
    ans = 1
    for num in seq[1:]:
        if num <= q[-1]:
            low, high = 0, len(q) - 1
            while low < high:
                mid = (low + high) // 2
                if q[mid] >= num:
                    high = mid
                else:
                    low = mid + 1
            q[high] = num
        else:
            q.append(num)
            ans += 1
    print(ans)


def reader():
    n = int(s.readline().strip())
    seq = map(int, s.readline().split())
    solution(list(seq), n)


if __name__ == '__main__':
    reader()
