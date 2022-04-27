def reader():
    a, b = map(int, input().split())
    q, r = divmod(a, b)
    print(f'{a + b}\n{a - b}\n{a * b}\n{q}\n{r}')


if __name__ == '__main__':
    reader()
