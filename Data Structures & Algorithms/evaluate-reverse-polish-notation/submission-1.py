class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for elem in tokens:
            if elem in "+-*/":
                y = int(stack.pop())
                x = int(stack.pop())

                total = self.calc(x, y, elem)
                stack.append(str(total))
                continue
            stack.append(elem)
        return int(stack[0])

    def calc(self, x: int, y: int, op: str):
        if op == "+":
            return x + y
        elif op == "-":
            return x - y
        elif op == "/":
            return int(x / y)
        
        return x * y