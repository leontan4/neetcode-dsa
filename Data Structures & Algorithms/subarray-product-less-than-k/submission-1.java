class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int winStart = 0;
        int prod = 1;
        if(k <=1) return 0;
        for (int winEnd = 0; winEnd < nums.length; winEnd++) {
            prod = nums[winEnd] * prod;
            while (prod >= k) {
                prod = prod / nums[winStart];
                winStart++;
            }
            count += winEnd - winStart + 1;
        }
        return count;
    }
}