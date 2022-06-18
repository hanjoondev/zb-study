from sys import stdin


class Heap:
    def __init__(self):
        self.h = []

    def b(self, data):
        self.h.append(data)
        p = ((i := len(self.h) - 1) - 1) // 2
        while i and self.h[p] > self.h[i]:
            self.h[p], self.h[i] = self.h[i], self.h[p]
            p = ((i := p) - 1) // 2

    def t(self, data):
        self.h[0], p, l, r = data, 0, 1, 2
        i = r if r < (hl := len(self.h)) and self.h[l] > self.h[r] else l
        while i < hl and self.h[p] > self.h[i]:
            self.h[p], self.h[i] = self.h[i], self.h[p]
            p, l, r = i, 2 * i + 1, 2 * i + 2
            i = r if r < hl and self.h[l] > self.h[r] else l


def reader():
    read = stdin.readline
    n, h = int(read()) - 1, Heap()
    for i in map(int, read().split()):
        h.b(i)
    for _ in range(n):
        for i in map(int, read().split()):
            if i > h.h[0]:
                h.t(i)
    print(h.h[0])


if __name__ == '__main__':
    reader()
