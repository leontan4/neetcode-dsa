class Solution {
    public int maxArea(int[] heights) {
        
        // Remeber about height * width
        // H = elem in array
        // W = index betwen R and L
        // how do we know if this container can contains water
        // We determine it based on the smallest height. (min)
        // Then the height will be min * width (R - L)
        // How to move index R o r L, we move conditonally
        // move L if L <= R and move R if R is bigger than L? 

        int L = 0; 
        int R = heights.length - 1;
        int max = Integer.MIN_VALUE;

        while(L < R){
            int height = Math.min(heights[L], heights[R]);
            int area = height * (R - L);
            max = Math.max(max, area);

            if(heights[L] > heights[R]){
                R--;
            } else{
                L++;
            }
        }

        return max;
    }
}
