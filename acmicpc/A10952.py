def reader():
    while (nums := input()) != '0 0':
        print(sum(map(int, nums.split())))


if __name__ == '__main__':
    reader()
