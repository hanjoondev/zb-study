from time import perf_counter_ns as ns


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
    def get_values(self) -> list[int]:
        values, h = [], self
        while h:
            values.append(h.val)
            h = h.next
        return values


class Solution:
    def reverseBetween(self, head: ListNode, l: int, r: int) -> ListNode:
        if not head.next or l == r:
            return head
        prev, cur = None, head
        for _ in range(l - 1):
            prev, cur = cur, cur.next
        orig_tail, rvsd_tail, rvsd = prev, cur, None
        for _ in range(l, r + 1):
            cur.next, cur, rvsd = rvsd, cur.next, cur
        if not orig_tail:
            rvsd_tail.next = cur
            return rvsd
        orig_tail.next, rvsd_tail.next = rvsd, cur
        return head


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2, 4, ListNode(1, ListNode(4, ListNode(3, ListNode(2, ListNode(5)))))),
        (ListNode(5), 1, 1, ListNode(5)),
        (ListNode(3, ListNode(5)), 1, 2, ListNode(5, ListNode(3))),
        (ListNode(3, ListNode(5, ListNode(4))), 1, 2, ListNode(5, ListNode(3, ListNode(4)))),
        (ListNode(3, ListNode(5, ListNode(4))), 2, 3, ListNode(3, ListNode(4, ListNode(5)))),
    )
    s = Solution()
    for node, left, right, expected in tests:
        print(f'reverseBetween({node.get_values()}, {left}, {right}) returned', end=' ')
        if (result := s.reverseBetween(node, left, right)).get_values() == expected.get_values():
            print(f'the expected result {expected.get_values()}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.reverseBetween(node, left, right)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
