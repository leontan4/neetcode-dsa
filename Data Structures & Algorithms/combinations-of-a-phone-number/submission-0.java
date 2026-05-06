class Solution {
List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0) return res;

        int k = digits.length();
        String[] letters = new String[k];
        digitToLetters(letters, digits);

        StringBuilder sb = new StringBuilder();
        dfs(0, letters, sb, k);
        return res;
    }

    public void dfs(int pos, String[] letters, StringBuilder sb, int k){
        if(sb.length() == k){
            String comb = sb.toString();
            res.add(comb);
            return;
        }

        for(int index = pos; index < letters.length; index++){
            for(char c : letters[index].toCharArray()){
                sb.append(c);
                dfs(index + 1, letters, sb, k);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void digitToLetters(String[] letters, String digits){
        int index = 0;

        for(char c : digits.toCharArray()){
            StringBuilder sb = new StringBuilder();
            if(c == '2') sb.append("abc");
            if(c == '3') sb.append("def");
            if(c == '4') sb.append("ghi");
            if(c == '5') sb.append("jkl");
            if(c == '6') sb.append("mno");
            if(c == '7') sb.append("pqrs");
            if(c == '8') sb.append("tuv");
            if(c == '9') sb.append("wxyz");

            letters[index] = sb.toString();
            index++;
        }
    }
}
