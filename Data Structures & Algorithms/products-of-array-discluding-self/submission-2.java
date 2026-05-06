class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] res = new int[n];
        
        prefix[0] = 1;
        postfix[n-1] = 1;

        for(int i=1; i<n; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        for(int num : prefix){
            System.out.println(num);

        }
        for(int i=n-2; i>=0; i--){
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++){
            res[i] = prefix[i] * postfix[i];
        }
        // [1,1,2,8]
        // [1,2,4,6]
        // [48,24,6,1]

        // [1,-1,0,0,0]
        // [-1,0,1,2,3]
        // [0,6,6,3,1]
        return res;
    }
}  
