class Solution {
    public int climbStairs(int n) {
        // memoization is to create DS to store "seen"

        int[] cache = new int[n + 1];
        return memo(n, cache) + 1;

    }

    public int memo(int n, int[] cache){
        if(n <= 1){
            return n;
        }

        // if found
        if(cache[n] != 0){
            return cache[n];
        }

        // if not found we store it
        cache[n] = memo(n - 1, cache) + memo(n - 2, cache);
        return cache[n];
    }
}
