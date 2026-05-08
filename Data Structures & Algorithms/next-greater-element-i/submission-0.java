class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // [4,1,2]
        // [1,3,4,2]
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < m; index++) {
            map.put(nums2[index], index);
        }

        // {1:0, 3:1, 4:2, 2:3}
        for (int i = 0; i < n; i++) {
            for (int j = map.get(nums1[i]) + 1; j < m; j++) {
                if (nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}