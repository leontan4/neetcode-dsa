class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            char c = str.charAt(i);
            char e = str.charAt(j);

            if(c != e) return false;
            i++;
            j--;
        }
        
        return true;
    }
}
