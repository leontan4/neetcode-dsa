class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for(int i=0; i<operations.length; i++){
            String operation = operations[i];

            if(operation.equals("+")){
                stack.add(total);
                total += total;
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