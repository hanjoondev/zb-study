from collections import deque as dq


class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        ans = dq()
        ans.append((sorted_intervals := sorted(intervals))[0])
        for interval in sorted_intervals[1:]:
            if ans[-1][-1] < interval[0]:
                ans.append(interval)
                continue
            f, s = ans.pop()
            ans.append([min(f, interval[0]), max(s, interval[1])])
        return ans
