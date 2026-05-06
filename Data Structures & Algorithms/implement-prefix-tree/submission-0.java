class PrefixTree {

    class TrieNode{
        boolean isWord;
        Map<Character, TrieNode> child;

        TrieNode(){
            this.isWord = false;
            this.child = new HashMap<>();
        }
    }

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(!curr.child.containsKey(c)){
                curr.child.put(c, new TrieNode());
            }
            curr = curr.child.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr = curr.child.get(c);
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(char c : prefix.toCharArray()){
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr = curr.child.get(c);
        }
        return true;
    }
}
