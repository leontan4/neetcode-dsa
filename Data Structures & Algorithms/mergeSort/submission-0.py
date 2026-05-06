# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value

class Solution:
    def mergeSort(self, pairs: List[Pair]) -> List[Pair]:
        # need to have a base case
        return self.mergePairs(pairs, 0, len(pairs)-1)
        
    def mergePairs(self, pairs: List[Pair], start: int, end: int) -> List[Pair]:
        
        if (end - start + 1 <= 1):
            return pairs

        mid = start + (end - start) // 2
        self.mergePairs(pairs, start, mid)
        self.mergePairs(pairs, mid + 1, end)
        self.merge(pairs, start, mid, end)

        return pairs

    def merge(self, pairs: List[Pair], start: int, mid: int, end: int) -> None:
        
        # Creating two copy of arrays to compare the elements and sort in ascending
        L = pairs[start : mid + 1]
        R = pairs[mid + 1 : end + 1]

        # Assign the starting index to modify element position
        i = 0
        j = 0
        k = start

        # looping to compare and make sure not out of bound
        while (i < len(L) and j < len(R)):
            if(L[i].key <= R[j].key):
                pairs[k] = L[i]
                i += 1
            else:
                pairs[k] = R[j]
                j += 1
            k += 1

        # Rest of the elements that are leftover are either equal or greater and we just sort them back
        while(i < len(L)):
            pairs[k] = L[i]
            i += 1
            k += 1
         
        while(j < len(R)):
            pairs[k] = R[j]
            j += 1
            k += 1