class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int count = 0;
        int L = 0;
        int sum = 0;

        for(int R = 0; R < arr.length; R++){
            sum += arr[R];

            if(R - L + 1 >= k){
                double avg = sum / k;

                if(avg >= threshold){
                    count++;
                }
                sum -= arr[L];
                L++;
            }
        }

        return count;
    }
}