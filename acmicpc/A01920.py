from sys import stdin as s


def binary_search(arr, target, left, right):
    if arr[0] > target or arr[-1] < target:
        return '0'
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return '1'
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return '0'


def reader():
    n = int(s.readline())
    arr = sorted(list(map(int, s.readline().split())))
    m = int(s.readline())
    print('\n'.join(binary_search(arr, num, 0, n - 1) 
                    for num in map(int, s.readline().split())) + '\n')


if __name__ == '__main__':
    reader()
