class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int[][] updateIntervals = new int[n+1][2];
        for(int i=0; i<n; i++){
            updateIntervals[i] = intervals[i];
        }
        
        updateIntervals[n] = newInterval;
        Arrays.sort(updateIntervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(updateIntervals[0]);

        for(int[] interval : updateIntervals){
            int start   = interval[0];
            int end     = interval[1];
            int lastEnd = res.get(res.size() - 1)[1];

            if(start <= lastEnd){
                res.get(res.size() - 1)[1] = Math.max(lastEnd, end);
            } else{
                res.add(new int[]{start, end});
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}