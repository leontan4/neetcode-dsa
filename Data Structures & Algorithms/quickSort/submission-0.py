# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value
class Solution:
    def quickSort(self, pairs: List[Pair]) -> List[Pair]:
        return self.quickSortHelper(pairs, 0, len(pairs)-1)

    def quickSortHelper(self, pairs: List[Pair], start: int, end: int) -> List[Pair]:

        # Base Case
        if (end - start + 1 <= 1):
            return pairs

        # Picking the pivot
        pivot = pairs[end].key
        left = start

        # Partition the arrays
        for i in range(start, end):
            
            if(pairs[i].key < pivot):
                temp = pairs[i]
                pairs[i] = pairs[left]
                pairs[left] = temp
                left += 1

        # swap pivot with where left stopped
        temp = pairs[end]
        pairs[end] = pairs[left]
        pairs[left] = temp

        # Recursion
        self.quickSortHelper(pairs, start, left-1)
        self.quickSortHelper(pairs, left+1, end)

        return pairs
