from sys import stdin as s


def binary_search(cables, len_cables, n):
    low, high = 0, 2_147_483_648 - 1
    while low <= high:
        length = (low + high) // 2
        count = 0
        for cable in cables:
            count += cable // length
        if count < n:
            high = length - 1
        else:
            low = length + 1
    print(high)



def reader():
    k, n = map(int, s.readline().split())
    cables = [int(s.readline().strip()) for _ in range(k)]
    binary_search(cables, k, n)


if __name__ == '__main__':
    reader()
