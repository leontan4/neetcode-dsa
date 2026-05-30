class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        dupes = set()

        for x in nums:
            if x in dupes:
                return True
            dupes.add(x)
        return False