class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int L = 0;
        int max = Integer.MIN_VALUE;
        int freq = Integer.MIN_VALUE;

        for (int R = 0; R < s.length(); R++) {
            char cR = s.charAt(R);
            map.put(cR, map.getOrDefault(cR, 0) + 1);
            freq = Math.max(freq, map.get(cR));

            while ((R - L + 1) - freq > k) {
                char cL = s.charAt(L);
                map.put(cL, map.get(cL) - 1);
                L++;
            }

            max = Math.max(max, R - L + 1);
        }
        return max;
        //  0 1 2 3 4 5 6
        // [B,A,A,A,B]
        //  R
        //  L
        // {A:0, B:0}
        // (R - L + 1) - map.get(R) > k
        // 
    }
}