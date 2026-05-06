class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        if(s.length() != t.length()) return false;

        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            count[cs - 'a']++;
            count[ct - 'a']--;
        }

        for(int i=0; i<count.length; i++){
            if(count[i] != 0) return false;
        }
        return true;
    }
}
