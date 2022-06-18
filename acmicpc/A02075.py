from sys import stdin


class Heap:
    def __init__(self):
        self.h = []

    def insert(self, data):
        self.h.append(data)
        p = ((i := len(self.h) - 1) - 1) // 2
        while i and self.h[p] > self.h[i]:
            self.h[p], self.h[i], i = self.h[i], self.h[p], p
            p = (i - 1) // 2

    def pop(self):
        self.h[-1], self.h[0], i = self.h[0], self.h[-1], 0
        smallest, length = self.h.pop(), len(self.h)
        while (lft := 2 * i + 1) < length:
            if (rgt := 2 * i + 2) < length and self.h[lft] > self.h[rgt]:
                lft = rgt
            if self.h[lft] > self.h[i]:
                break
            self.h[lft], self.h[i], i = self.h[i], self.h[lft], lft
        return smallest


def reader():
    read = stdin.readline
    n, h = int(read()) - 1, Heap()
    for i in list(map(int, read().split())):
        h.insert(i)
    for _ in range(n):
        for i in list(map(int, read().split())):
            if i > h.h[0]:
                h.pop()
                h.insert(i)
    print(h.pop())


if __name__ == '__main__':
    reader()
