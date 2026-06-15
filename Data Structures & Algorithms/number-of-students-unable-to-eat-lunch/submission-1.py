class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:

        count = Counter(students)
        res = len(students)

        for index in sandwiches:
            if count[index] > 0:
                res -= 1
                count[index] -= 1
            else:
                break
        return res