class Solution {
    int moves = 0;
    
    public int distCandy(Node root) {
        dfs(root);
        return moves;
    }
    
    private int dfs(Node node) {
        if (node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        // count moves
        moves += Math.abs(left) + Math.abs(right);
        
        // return balance
        return node.data + left + right - 1;
    }
}