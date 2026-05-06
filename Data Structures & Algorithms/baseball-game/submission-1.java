class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        // ["5","-2","4","C","D","9","+","+"]
        // [5,-2,4,9]
        // total = 32
        for(int i=0; i<operations.length; i++){
            String operation = operations[i];

            if(operation.equals("+")){
                int first = stack.peek();
                int second = stack.get(stack.size() - 2);
                int sum = first + second;
                stack.add(sum);
                total += sum;
            } else if(operation.equals("C")){
                total -= stack.pop();
            } else if(operation.equals("D")){
                int num = stack.peek() * 2;
                stack.add(num);
                total += num;
            } else{
                stack.add(Integer.parseInt(operation));
                total += Integer.parseInt(operation);
            }
        }
        return total;
    }
}