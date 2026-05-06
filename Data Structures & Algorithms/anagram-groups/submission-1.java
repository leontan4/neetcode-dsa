class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];

            for(char c: s.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s); 
        }
        return new ArrayList<>(map.values());
    }
}


// Input: strs = ["act","pots","tops","cat","stop","hat"]

// [a, c, t]
// Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]