class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[2] - a[2];
        });

        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dist = eucli(x, y);

            if(maxHeap.isEmpty() || maxHeap.size() < k){
                maxHeap.offer(new int[]{x, y, dist});
            } else if(maxHeap.peek()[2] > dist){
                maxHeap.poll();
                maxHeap.offer(new int[]{x, y, dist});
            }
        }

        List<int[]> res = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            int[] point = maxHeap.poll();
            res.add(new int[]{point[0], point[1]});
        }

        return res.toArray(new int[res.size()][]);
    }

    public int eucli(int x, int y){
        int x_squared = (int) Math.pow(Math.abs(x), 2);
        int y_squared = (int) Math.pow(Math.abs(y), 2);

        return x_squared + y_squared;
    }
}