from sys import stdin


def dfs(root: dict[str, dict], depth: int) -> None:
    for k in sorted(root):
        dfs.ans.append(f'{"--" * depth}{k}')
        dfs(root[k], depth + 1)


def reader():
    read = stdin.readline
    root = {}
    for _ in range(int(read().rstrip())):
        d = root
        for t in read().split()[1:]:
            d.setdefault(t, {})
            d = d[t]
    dfs.ans = []
    dfs(root, 0)
    print('\n'.join(dfs.ans))


if __name__ == '__main__':
    reader()
