class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []

        for op in operations:

            if op == "+":
                x = int(stack.pop())
                y = int(stack.pop())

                total = x + y
                stack.append(y)
                stack.append(x)
                stack.append(total)
            elif op == "C":
                stack.pop()
            elif op == "D":
                x = int(stack[-1])
                x *= 2
                stack.append(x)
            else:
                stack.append(int(op))
            print(op)
            print(stack)
        res = 0
        while stack:
            res += int(stack.pop())
        
        return res
