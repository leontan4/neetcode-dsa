class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums2[i], i);
        }

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int index = stack.pop();
                res[index] = nums2[i];
            }
            stack.add(i);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            int index = map.get(nums1[i]);
            ans[i] = res[index];
        }
        return ans;
    }
}