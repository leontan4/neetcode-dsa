class Solution {
    public int climbStairs(int n) {
        // memoization is to create DS to store "seen"

        // int[] cache = new int[n + 1];
        Map<Integer, Integer> cache = new HashMap<>();
        return memo(n, cache);

    }

    public int memo(int n, Map<Integer, Integer> cache){
        if(n == 0 || n == 1){
            return 1;
        }

        // if found
        if(cache.containsKey(n)){
            return cache.get(n);
        }

        // if not found we store it
        cache.put(n, memo(n - 1, cache) + memo(n - 2, cache));
        // cache[n] = memo(n - 1, cache) + memo(n - 2, cache);
        return cache.get(n);
    }
}
