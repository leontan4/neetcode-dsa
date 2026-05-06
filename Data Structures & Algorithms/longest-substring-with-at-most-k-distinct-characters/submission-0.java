class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int L = 0;
        int max = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();

        for(int R = 0; R < s.length(); R++){
            char cR = s.charAt(R);

            map.put(cR, map.getOrDefault(cR, 0) + 1);

            while(map.size() > k){
                char cL = s.charAt(L);

                map.put(cL, map.get(cL) - 1);
                if(map.get(cL) == 0){
                    map.remove(cL);
                }
                L++;
            }
            max = Math.max(max, R - L + 1);
        }
        return max;
    }
}
