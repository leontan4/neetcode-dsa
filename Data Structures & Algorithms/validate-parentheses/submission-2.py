class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for op in s:
            if op == "]" and stack[-1] == "[":
                stack.pop()
            elif op == "}" and stack[-1] == "{":
                stack.pop()
            elif op == ")" and stack[-1] == "(":
                stack.pop()
            else:
                stack.append(op)
        
        return not stack