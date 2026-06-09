class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:

        n = len(arr)
        L = 0
        count = 0
        total = 0

        for R in range(n):
            total += arr[R]
            
            if R - L + 1 == k:
                avg = total / k

                if avg >= threshold:
                    count += 1
                total -= arr[L]
                L += 1

        return count
