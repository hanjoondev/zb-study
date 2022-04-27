def reader():
    for i in range(int(input())):
        repeat, s = input().split()
        print(''.join(c * int(repeat) for c in s))


if __name__ == '__main__':
    reader()
