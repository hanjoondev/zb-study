from sys import stdin


def fib(nums: list[int]) -> str:
    f = [1, 0, 1]
    for _ in range(max(nums) - 1):
        f.append(f[-1] + f[-2])
    return '\n'.join(f'{f[n]} {f[n + 1]}' for n in nums)


def reader():
    read = stdin.readline
    print(fib([int(read()) for _ in range(int(read()))]))


if __name__ == '__main__':
    reader()
