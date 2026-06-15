class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:

        dq = deque(students)
        index = 0

        while index < len(sandwiches):
            count = 0
            food = sandwiches[index]

            while dq[0] != food:
                if count == len(sandwiches):
                    return len(dq)
                pos = dq.popleft()
                dq.append(pos)
                count += 1
                
            dq.popleft()
            index += 1

        return len(dq)
        # [1,1,1]
        # [1,0,0,0,1,1]
        #        i 
