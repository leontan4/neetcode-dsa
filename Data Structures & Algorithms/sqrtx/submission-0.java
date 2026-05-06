class Solution {
    public int mySqrt(int x) {
        if(x > 0 && x <= 3) return 1;
        int start = 0;
        int end = x/2;

        while(start <= end){
            int mid = start + (end - start) / 2;
            long target = (long) mid * mid;
            
            if(target > x){
                end = mid - 1;
            } else if(target < x){
                start = mid + 1;
            } else{
                return mid;
            }
        }

        return end;
    }
}