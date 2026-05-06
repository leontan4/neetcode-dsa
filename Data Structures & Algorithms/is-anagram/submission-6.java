class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        char[] count = new char[26];

        for(int i = 0 ; i < sc.length; i++){
            count[sc[i] - 'a']++;
            count[tc[i] - 'a']--;
        }

        for(int i=0; i<count.length; i++){
            if(count[i] != 0) return false;
        }

        return true;
    }
}
