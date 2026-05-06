class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];

        int res = 1;
        int zeroCount = 0;

        for (int index = 0; index < nums.length; index++) {

            if (nums[index] != 0) {
                res *= nums[index];
            }

            if (nums[index] == 0) {
                zeroCount++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (zeroCount >= 1 && nums[index] != 0) {
                prefix[index] = 0;
            } else if (nums[index] == 0) {
                prefix[index] = res;
            } else {
                prefix[index] = res / nums[index];
            }
        }
        int[] post = new int[nums.length];
        return zeroCount >= 2 ? post : prefix;
    }
}