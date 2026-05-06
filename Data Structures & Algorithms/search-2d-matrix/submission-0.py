class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        for i in range(len(matrix)):
            start, end = 0, len(matrix[i])-1

            while start <= end:

                mid = (start + end) // 2
                elem = matrix[i][mid]

                if(elem == target):
                    return True
                elif(elem > target):
                    end = mid - 1
                elif(elem < target):
                    start = mid + 1
        

        return False