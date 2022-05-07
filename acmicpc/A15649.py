from sys import stdin as s


def perm(iterable, r=None) -> tuple[int]:
    pool = tuple(iterable)
    n = len(pool)
    r = n if r is None else r
    if r > n:
        return
    indices = list(range(n))
    cycles = list(range(n, n-r, -1))
    yield tuple(pool[i] for i in indices[:r])
    while n:
        for i in reversed(range(r)):
            cycles[i] -= 1
            if cycles[i] == 0:
                indices[i:] = indices[i+1:] + indices[i:i+1]
                cycles[i] = n - i
            else:
                j = cycles[i]
                indices[i], indices[-j] = indices[-j], indices[i]
                yield tuple(pool[i] for i in indices[:r])
                break
        else:
            return

def solution(n: int, r: int) -> None:
    perms = [' '.join(str(num) for num in p) 
             for p in perm(range(1, n + 1), r)]
    print(('\n'.join(perms) if perms else '') + '\n')


def reader():
    n, r = map(int, s.readline().split())
    solution(n, r)


if __name__ == '__main__':
    reader()
