class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for op in s:
                
            if not stack:
                stack.append(op)
            elif op == "]" and stack[-1] == "[":
                stack.pop()
            elif op == "}" and stack[-1] == "{":
                stack.pop()
            elif op == ")" and stack[-1] == "(":
                stack.pop()
            else:
                stack.append(op)
        
        print(stack)
        return not stack