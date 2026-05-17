class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
                continue;
            } else if(merged.getLast()[1] >= interval[0] && merged.getLast()[1] < interval[1]){
                merged.getLast()[1] = interval[1];
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}