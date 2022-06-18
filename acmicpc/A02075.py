from sys import stdin


class Heap:
    def __init__(self):
        self.heap = []

    def parent(self, i):
        return (i - 1) // 2

    def lft(self, i):
        return 2 * i + 1

    def rgt(self, i):
        return 2 * i + 2

    def insert(self, data):
        self.heap.append(data)
        p = self.parent(i := (len(self) - 1))
        while i and self.heap[p] > self.heap[i]:
            self.heap[p], self.heap[i], i = self.heap[i], self.heap[p], p
            p = self.parent(i)

    def pop(self):
        if not self.heap:
            return None
        self.heap[-1], self.heap[0], i = self.heap[0], self.heap[-1], 0
        smallest = self.heap.pop()
        while (l := self.lft(i)) < len(self):
            if (r := self.rgt(i)) < len(self) and self.heap[l] > self.heap[r]:
                l = r
            if self.heap[l] > self.heap[i]:
                break
            self.heap[l], self.heap[i], i = self.heap[i], self.heap[l], l
        return smallest

    def peek(self):
        return self.heap[0]

    def __len__(self):
        return len(self.heap)


def reader():
    read = stdin.readline
    n, h = int(read()) - 1, Heap()
    for i in list(map(int, read().split())):
        h.insert(i)
    for _ in range(n):
        for i in list(map(int, read().split())):
            if i > h.peek():
                h.pop()
                h.insert(i)
    print(h.pop())


if __name__ == '__main__':
    reader()
