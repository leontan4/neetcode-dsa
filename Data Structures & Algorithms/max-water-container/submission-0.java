class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j){
            int height = Math.min(heights[i], heights[j]);
            int weight = j - i;
            maxArea = Math.max(maxArea, height * weight);

            if(heights[i] >= heights[j]){
                j--;
            } else{
                i++;
            }
        }
        return maxArea;
    }
}
