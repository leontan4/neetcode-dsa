class Solution {
    public boolean isAnagram(String s, String t) {

        int[] res = new int[26];

        if(s.length() != t.length()) return false;

        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            res[cs - 'a']++;
            res[ct - 'a']--;
        }

        for(int i=0; i<res.length; i++){
            if(res[i] == -1) return false;
        }
        return true;
    }
}
