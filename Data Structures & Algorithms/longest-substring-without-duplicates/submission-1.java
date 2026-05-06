class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0;
        int max = Integer.MIN_VALUE;
        char[] sc = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        // "zxyzxyz"
        for(int R = 0; R < sc.length; R++){
            char c = sc[R];
            
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1){
                map.put(sc[L], map.get(sc[L]) - 1);
                L++;

                if(map.get(sc[L]) == 0){
                    map.remove(sc[L]);
                }
            }

            max = Math.max(R - L + 1, max);
        }
        return max;
    }
}
