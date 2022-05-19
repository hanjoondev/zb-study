from sys import stdin


class Kruskal:
    def __init__(self, v: int):
        self.v = v
        self.g = []
        self.p = [i for i in range(v)]
        self.r = [0] * v

    def add(self, e: tuple[int]):
        self.g.append(e)

    def parent(self, i):
        while i != self.p[i]:
            i = self.p[i]
        return i

    def union(self, a, b):
        if self.r[a := self.parent(a)] < self.r[b := self.parent(b)]:
            self.p[a] = b
        else:
            self.p[b] = a
            self.r[a] += self.r[a] == self.r[b]

    def kruskal(self):
        self.g.sort(key=lambda x: x[2])
        i = e = result = 0
        while e < self.v - 1:
            (u, v, w), i = self.g[i], i + 1
            if (u := self.parent(u)) != (v := self.parent(v)):
                result, e = result + w, e + 1
                self.union(u, v)
        return result


def reader():
    read = stdin.readline
    v, e = map(int, read().split())
    graph = Kruskal(v)
    for _ in range(e):
        u, v, w = map(int, read().split())
        graph.add((u - 1, v - 1, w))
    print(graph.kruskal())


if __name__ == '__main__':
    reader()
