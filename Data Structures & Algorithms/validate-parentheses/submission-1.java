class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1) return false;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(
                    (c == ']' && stack.peek() == '[') ||
                    (c == '}' && stack.peek() == '{') ||
                    (c == ')' && stack.peek() == '(')
                ){
                    stack.pop();
                } else{
                    stack.push(c);
                }
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
