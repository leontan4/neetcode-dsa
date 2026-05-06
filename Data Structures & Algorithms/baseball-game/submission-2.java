class Solution {
    public int calPoints(String[] operations) {
        int total = 0;
        Stack<Integer> stack = new Stack<>();

        // ["5","-2","4","C","D","9","+","+"]
        for(String op : operations){

            if(op.equals("+")){
                int first = stack.pop();
                int newNum = first + stack.peek();
                stack.push(first);
                stack.push(newNum);
                total += newNum;
            } else if(op.equals("C")){
                total -= stack.pop();
            } else if(op.equals("D")){
                stack.push(stack.peek() * 2);
                total+= stack.peek();
            } else{
                stack.push(Integer.parseInt(op));
                total += stack.peek();
            }
        }

        return total;
    }
}