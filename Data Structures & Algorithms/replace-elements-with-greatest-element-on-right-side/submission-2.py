class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        res = [0] * n

        for L in range(n - 1):
            curr_max = 0
            for R in range(L + 1, n):
                curr_max = max(curr_max, arr[R])

            res[L] = curr_max
        res[n-1] = -1
        return res