class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            char[] words = new char[26];

            for(char c : str.toCharArray()){
                words[c - 'a']++;
            }

            String word = new String(words);

            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(str);
        }

        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
