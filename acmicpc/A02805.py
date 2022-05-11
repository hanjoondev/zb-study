from sys import stdin as s


def binary_search(trees, required):
    low, high = 0, int(2e9)
    while low <= high:
        cutting_h = (low + high) // 2
        remainders = sum(t - cutting_h for t in trees if t > cutting_h)
        if remainders < required:
            high = cutting_h - 1
        else:
            low = cutting_h + 1
    print(high)


def reader():
    n, m = map(int, s.readline().split())
    trees = list(map(int, s.readline().split()))
    binary_search(trees, m)


if __name__ == '__main__':
    reader()
