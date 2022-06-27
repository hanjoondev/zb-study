from sys import stdin


def reader():
    target, found, i, t = 'UCPC', False, 0, 'U'
    for c in stdin.readline().strip():
        if c != t:
            continue
        if i < 3:
            t = target[i := i + 1]
            continue
        found = True
        break
    print(f"I {'love' if found else 'hate'} UCPC")


if __name__ == '__main__':
    reader()
