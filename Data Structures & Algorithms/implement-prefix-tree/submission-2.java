class PrefixTree {

    class TrieNode{
        boolean isWord;

        TrieNode[] child;

        TrieNode(){
            this.isWord = false;
            this.child = new TrieNode[26];
        }
    }

    TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(curr.child[c - 'a'] == null){
                curr.child[c - 'a'] = new TrieNode();
            }
            curr = curr.child[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(curr.child[c - 'a'] == null){
                return false;
            }
            curr = curr.child[c - 'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;

        for(char c : prefix.toCharArray()){
            if(curr.child[c - 'a'] == null){
                return false;
            }
            curr = curr.child[c - 'a'];
        }
        return true;
    }
}
