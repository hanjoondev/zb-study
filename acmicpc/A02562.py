from sys import stdin as s


def reader():
    nums = []
    while True:
        try:
            nums.append(int(s.readline()))
        except:
            break
    print(max_num := max(nums))
    print(nums.index(max_num) + 1)


if __name__ == '__main__':
    reader()
