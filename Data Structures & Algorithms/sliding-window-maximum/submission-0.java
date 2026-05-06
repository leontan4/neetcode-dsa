class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int index = 0; index < n; index++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[index]) {
                dq.pollLast();
            }
            dq.offerLast(index);

            if (dq.peekFirst() <= index - k) {
                dq.pollFirst();
            }

            if (index >= k - 1) {
                res[index - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;  
    }
}
