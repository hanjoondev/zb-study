def reader():
    for _ in range(int(input())):
        s = input()
        ans = (cur := 1 if s[0] == 'O' else 0)
        for c in s[1:]:
            if c == 'O':
                ans += (cur := cur + 1)
            else:
                cur = 0
        print(ans)


if __name__ == '__main__':
    reader()
