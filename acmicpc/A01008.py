from decimal import Decimal, getcontext


def reader():
    getcontext().prec = 32
    a, b = map(Decimal, input().split())
    print(a / b)


if __name__ == '__main__':
    reader()
