class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonic -> stack -> decreasing 
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> minStack = new Stack<>();
        
        for(int index=0; index<n; index++){
            while(!minStack.isEmpty() && temperatures[minStack.peek()] < temperatures[index]){
                int pos = minStack.pop();
                res[pos] = index - pos;
            }
            minStack.push(index);
        }

        return res;

    }
}
