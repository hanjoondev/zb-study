from sys import stdin


class UF:
    def __init__(self, length):
        self.parties = []
        self.parent = [i for i in range(length + 1)]
        self.r = [0] * (length + 1)

    def add(self, e: tuple[int]):
        self.parties.append(e)

    def find(self, i):
        while i != self.parent[i]:
            i = self.parent[i]
        return i

    def union(self, a, b):
        if self.r[a := self.find(a)] < self.r[b := self.find(b)]:
            self.parent[a] = b
        else:
            self.parent[b] = a
            self.r[a] += self.r[a] == self.r[b]


def solution(g: UF, t: dict[int, bool]):
    for k, v in t.items():
        if v:
            t[g.find(k)] = True
    return sum(all(not t[g.find(p)] for p in party) for party in g.parties)


def reader():
    read = stdin.readline
    n, m = map(int, read().split())
    length, *t = map(int, read().split())
    if not length:
        for _ in range(m):
            read()
        print(m)
        return
    t, graph = set(t), UF(n)
    for _ in range(m):
        length, *participants = map(int, read().split())
        graph.add(tuple(participants))
        if length > 1:
            for i, p in enumerate(participants[1:]):
                graph.union(participants[i], p)
    print(solution(graph, {i: i in t for i in range(1, n + 1)}))


if __name__ == '__main__':
    reader()
