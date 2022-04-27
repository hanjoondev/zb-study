def ops_required(n, k, s):
    return abs(k - sum(s[i] != s[n - i - 1] for i in range(n // 2)))


def reader():
    for case_no in range(int(input())):
        n, k = map(int, input().strip().split())
        s = input().strip()
        print(f'Case #{case_no + 1}: {ops_required(n, k, s)}')


if __name__ == '__main__':
    reader()
