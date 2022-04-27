def reader():
    while True:
        try:
            print(sum(map(int, input().split())))
        except:
            break


if __name__ == '__main__':
    reader()
