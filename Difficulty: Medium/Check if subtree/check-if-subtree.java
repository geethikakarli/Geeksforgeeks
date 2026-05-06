class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (isIdentical(root1, root2)) {
            return true;
        }
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
    private boolean isIdentical(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return (n1.data == n2.data) && 
               isIdentical(n1.left, n2.left) && 
               isIdentical(n1.right, n2.right);
    }
}