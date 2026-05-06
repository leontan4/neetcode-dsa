class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), n, 0, 0);
        return res;
    }

    public void backtrack(StringBuilder sb, int n, int open, int close){
        if(sb.length() == n * 2){
            String str = sb.toString();
            res.add(str);
            return;
        }

        // do something
        if(open < n){
            sb.append("(");
            backtrack(sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            backtrack(sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);  
        }
    }
}