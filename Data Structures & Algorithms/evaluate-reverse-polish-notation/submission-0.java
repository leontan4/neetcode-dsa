class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length <= 1) return Integer.parseInt(tokens[0]);

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                int y = stack.pop();
                int x = stack.pop();

                stack.push(calculations(x, y, token));
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }

    public boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }

    public int calculations(int a, int b, String op){
        if(op.equals("+")){
            return a + b;
        } else if(op.equals("-")){
            return a - b;
        } else if(op.equals("*")){
            return a * b;
        }
        return  a / b;
    }
}