class TrieNode{
    TrieNode[] children;
    boolean isWord;

    TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this.root);
    }

    private boolean dfs(String word, int pos, TrieNode root){
        TrieNode curr = root;

        for(int index=pos; index<word.length(); index++){
            char c = word.charAt(index);

            if(c == '.'){
                for(TrieNode child : curr.children){
                    if(child != null && dfs(word, index+1, child)){
                        return true;
                    }
                }
                return false;
            } else{
                if(curr.children[c - 'a'] == null){
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isWord;
    }
}
