class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        Stack<int[]> stack = new Stack<>();

        for(int[] interval : intervals){
            
            if(stack.isEmpty()){
                stack.add(interval);
            } else{
                int[] prevInterval = stack.peek();
                int currStart = interval[0];
                int currEnd = interval[1];

                int prevStart = prevInterval[0];
                int prevEnd = prevInterval[1];

                if(prevEnd >= currStart){
                    prevInterval[0] = prevStart;
                    if(prevEnd >= currEnd){
                        prevInterval[1] = prevEnd; 
                    } else{
                        prevInterval[1] = currEnd;
                    }
                    stack.pop();
                    stack.add(prevInterval);
                } else{
                    stack.add(interval);
                }                
            }
        }

        int[][] res = new int[stack.size()][2];
        int index = res.length - 1;
        while(!stack.isEmpty() && index >= 0){
            int[] pair = stack.pop();
            res[index][0] = pair[0];
            res[index][1] = pair[1];
            index--;
        }
        return res;
    }
}