def reader():
    nums = [int(i) for i in input().split()]
    asc = desc = False
    for i, num in enumerate(nums[1:]):
        asc = num > nums[i] if not asc else asc
        desc = num < nums[i] if not desc else asc
    print('mixed' if asc and desc else 'ascending' if asc else 'descending')


if __name__ == '__main__':
    reader()
