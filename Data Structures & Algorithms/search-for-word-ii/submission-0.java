class TrieNode {
    boolean isWord;
    TrieNode[] children;

    TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

class PrefixTree {
    TrieNode root;
    TrieNode[] children;

    PrefixTree() {
        this.root = new TrieNode();
        this.children = this.root.children;
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
}

class Solution {

    private Set<String> res = new HashSet<>();
    private boolean[][] visited;
    private int m;
    private int n;

    public List<String> findWords(char[][] board, String[] words) {
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];

        PrefixTree trie = new PrefixTree();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            trie.insert(word);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dfs(board, r, c, trie.root, sb);                    
                
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int r, int c, TrieNode root, StringBuilder sb) {
        if (!isValid(board, r, c, root)) {
            return;
        }

        sb.append(board[r][c]);
        root = root.children[board[r][c] - 'a'];
        
        if(root.isWord){
            res.add(sb.toString());
        }

        visited[r][c] = true;
        dfs(board, r - 1, c, root, sb);
        dfs(board, r + 1, c, root, sb);
        dfs(board, r, c + 1, root, sb);
        dfs(board, r, c - 1, root, sb);
        sb.deleteCharAt(sb.length()-1);
        visited[r][c] = false;
    }

    public boolean isValid(char[][] board, int r, int c, TrieNode root) {
        if (Math.min(r, c) < 0 || r >= m || c >= n || root.children[board[r][c] - 'a'] == null || visited[r][c]) {
            return false;
        }
        return true;
    }
}