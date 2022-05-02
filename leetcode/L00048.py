class Solution:
    def rotate(self, m: list[list[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        for r in range((h := len(m)) // 2):
            for c in range(r, (hr := h - r - 1)):
                hc = h - c - 1
                m[r][c], m[hc][r], m[hr][hc], m[c][hr] = (
                    m[hc][r], m[hr][hc], m[c][hr], m[r][c])
