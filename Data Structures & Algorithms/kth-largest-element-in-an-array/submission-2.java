class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[100001];

        for(int num : nums){
            count[num]++;
        }

        int n = count.length;
        for(int i=n-1; i>=0; i--){
            while(count[i] > 0){
                count[i]--;
                k--;

                if(k == 0){
                    return i;
                }
            }
        }
        return -1;
    }
}
