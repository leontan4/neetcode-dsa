class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int L = 0;
        Set<Integer> set = new HashSet<>();

        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                set.remove(nums[L]);
                L++;
            }

            if (set.contains(nums[R])) {
                return true;
            }

            set.add(nums[R]);
        }
        return false;
    }
}
 