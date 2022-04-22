from time import perf_counter_ns as ns
from collections import deque as dq


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return f'TreeNode({self.val, self.left, self.right})'


class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        deque = dq([(p, q), ])
        while deque:
            p, q = deque.popleft()
            if not (not p and not q) and (not p or not q or p.val != q.val):
                return False
            if p:
                deque.append((p.left, q.left))
                deque.append((p.right, q.right))
        return True


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (TreeNode(1, TreeNode(2), TreeNode(3)), TreeNode(1, TreeNode(2), TreeNode(3)), True),
        (TreeNode(1, TreeNode(2)), TreeNode(1, None, TreeNode(2)), False),
        (TreeNode(1, TreeNode(2), TreeNode(1)), TreeNode(1, TreeNode(1), TreeNode(2)), False)
    )
    s = Solution()
    for tree_p, tree_q, expected in tests:
        print(f'isSameTree({tree_p}, {tree_q}) returned', end=' ')
        if (result := s.isSameTree(tree_p, tree_q)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.isSameTree(tree_p, tree_q)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
