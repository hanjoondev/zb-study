class Solution:
    def generate(self, num_rows: int) -> list[list[int]]:
        ans = []
        for i in range(num_rows):
            ans.append([1 if not j or i == j else
                        sum(ans[i - 1][j - 1:j + 1]) for j in range(i + 1)])
        return ans


''' 118. Pascal's Triangle https://leetcode.com/problems/pascals-triangle/
https://leetcode.com/submissions/detail/679209083/
Runtime: 34 ms, faster than 77.64% of Python3 online submissions for Pascal's Triangle.
Memory Usage: 13.9 MB, less than 20.70% of Python3 online submissions for Pascal's Triangle.
'''
