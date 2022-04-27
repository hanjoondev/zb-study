def reader():
    a, b = map(int, input().split())
    print('>' if a > b else '<' if a < b else '==')


if __name__ == '__main__':
    reader()
