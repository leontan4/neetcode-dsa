class Solution {
    public int characterReplacement(String s, int k) {
        int L = 0;
        int maxf = 0;
        int maxCount = 0;
        
        Map<Character, Integer> map = new HashMap<>();

        for(int R=0; R<s.length(); R++){
            char c1 = s.charAt(R);

            map.put(c1, map.getOrDefault(c1, 0) + 1);
            maxf = Math.max(maxf, map.get(c1));

            while((R - L + 1) - maxf > k){
                char c2 = s.charAt(L);
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0){
                    map.remove(c2);
                }
                L++;
            }
            maxCount = Math.max(maxCount, R - L + 1);
        }

        return maxCount;
    }
}
