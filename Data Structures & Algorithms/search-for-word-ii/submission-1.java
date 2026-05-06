class TrieNode {
    private boolean isWord;
    private Map<Character, TrieNode> children;

    TrieNode(){
        this.isWord = false;
        this.children = new HashMap<>();
    }
}

class PrefixTree {
    public TrieNode root;
    public Map<Character, TrieNode> children;

    PrefixTree(){
        this.root = new TrieNode();
        this.children = root.children;
    }

    public void addWord(String word){
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}

class Solution {
    private Set<String> res = new HashSet<>();
    private boolean[][] visited;
    private int m;
    private int n;
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {-1, 0},
        {1, 0},
    };

    public List<String> findWords(char[][] board, String[] words) {
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[this.m][this.n];

        PrefixTree trie = new PrefixTree();
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            trie.addWord(word);
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                dfs(board, r, c, trie.root, sb);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, StringBuilder sb) {
        if(!isValid(board, r, c, node)) return;

        sb.append(board[r][c]);
        node = node.children.get(board[r][c]);
        if(node.isWord){
            res.add(sb.toString());
        }

        visited[r][c] = true;
        for(int[] direction : directions){
            int x = direction[0] + r;
            int y = direction[1] + c;
            dfs(board, x, y, node, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[r][c] = false;
    }

    public boolean isValid(char[][] board, int r, int c, TrieNode node) {
        if(Math.min(r, c) < 0 || r >= m || c >= n || visited[r][c] || !node.children.containsKey(board[r][c])){
            return false;
        }
        return true;
    }
}
