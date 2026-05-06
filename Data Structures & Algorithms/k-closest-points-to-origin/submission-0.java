class Solution {
    public int[][] kClosest(int[][] points, int k) {
    
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a, int[] b){
                int a_eul = dist(a[0], a[1]);
                int b_eul = dist(b[0], b[1]);

                return a_eul - b_eul;
            }
        });

        for(int[] point : points){
            pq.offer(point);
        }

        List<int[]> res = new ArrayList<>();
        int j = 0;

        while(!pq.isEmpty() && j < k){
            int[] coor = pq.poll();
            res.add(coor);
            j++;
            // int x = coor[0];
            // int y = coor[1];

            // System.out.println("x: " + x + " y: " + y);
        }
        return res.toArray(new int[0][]);
    }

    public int dist(int x1, int y1){
        int x_diff = Math.abs(x1);
        int y_diff = Math.abs(y1);

        int x_square = x_diff * x_diff;
        int y_square = y_diff * y_diff;

        int total = x_square + y_square;
        return total;
    }
}
