from sys import stdin


def reader():
    read = stdin.readline
    n = int(read())
    building = list(map(int, read().split()))
    ans = 0
    for i, b in enumerate(building):
        r_theta = l_theta = -float('inf')
        r_count = l_count = 0
        for right in range(i + 1, n):
            adjacent, opposite = right - i, building[right] - b
            if (tmp := opposite / adjacent) > r_theta:
                r_theta = tmp
                r_count += 1
        for left in range(i - 1, -1, -1):
            adjacent, opposite = i - left, building[left] - b
            if (tmp := opposite / adjacent) > l_theta:
                l_theta = tmp
                l_count += 1
        ans = max(ans, r_count + l_count)
    print(ans)


if __name__ == '__main__':
    reader()
