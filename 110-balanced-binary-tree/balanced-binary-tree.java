class Solution {
    
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        
        int left = checkHeight(node.left);
        if (left == -1) return -1;   // Left subtree not balanced
        
        int right = checkHeight(node.right);
        if (right == -1) return -1;  // Right subtree not balanced
        
        if (Math.abs(left - right) > 1) return -1; // Not balanced
        
        return Math.max(left, right) + 1; // Return height
    }
}
