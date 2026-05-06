class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int R = 0; R < s.length(); R++) {
            char c1 = s.charAt(R);

            while (map.containsKey(c1)) {
                char c2 = s.charAt(L);
                map.put(c2, map.get(c2) - 1);

                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
                L++;
            }

            map.put(c1, 1);
            max = Math.max(max, R - L + 1);
        }
        return max;
    }
}
