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
    def reorderList(self, head: ListNode) -> None:
        if not head or not head.next or not head.next.next:
            return
        half, full = head, head.next
        while full and full.next:
            half, full = half.next, full.next.next
        rvsd = half.next
        prev = half.next = None
        while rvsd:
            rvsd.next, rvsd, prev = prev, rvsd.next, rvsd
        rvsd = prev
        while rvsd:
            head.next, rvsd.next, head, rvsd = rvsd, head.next, head.next, rvsd.next


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (ListNode(1, ListNode(2, ListNode(3, ListNode(4)))), ListNode(1, ListNode(4, ListNode(2, ListNode(3))))),
        (ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), ListNode(1, ListNode(5, ListNode(2, ListNode(4, ListNode(3)))))),
    )
    s = Solution()
    for node, expected in tests:
        print(f'reorderList({node.get_values()}) modified the head to', end=' ')
        s.reorderList(node)
        if (result := node.get_values()) == expected.get_values():
            print(f'the expected result {expected.get_values()}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.reorderList(node)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
