def reader():
    s = [sum(int(i) for i in eq.split('+')) for eq in input().split('-')]
    print(s[0] - sum(s[1:]))


if __name__ == '__main__':
    reader()
