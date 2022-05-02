class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True
        full = half = copy = head
        rvsd = None
        while full and full.next:
            full, half = full.next.next, half.next
        while half:
            half.next, half, rvsd = rvsd, half.next, half
        while copy and rvsd:
            if copy.val != rvsd.val:
                return False
            copy, rvsd = copy.next, rvsd.next
        return True
