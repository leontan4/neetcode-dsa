class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();

        for(char c : s.toCharArray()){
            map_s.put(c, map_s.getOrDefault(c, 1) + 1);
        }

        for(char c : t.toCharArray()){
            map_t.put(c, map_t.getOrDefault(c, 1) + 1);
        }

        return Objects.equals(map_s, map_t);
    }
}
