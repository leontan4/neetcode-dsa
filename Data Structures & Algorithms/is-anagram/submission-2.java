class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            map_s.put(cs, map_s.getOrDefault(cs, 1) + 1);
            map_t.put(ct, map_t.getOrDefault(ct, 1) + 1);
        }

        return Objects.equals(map_s, map_t);
    }
}
