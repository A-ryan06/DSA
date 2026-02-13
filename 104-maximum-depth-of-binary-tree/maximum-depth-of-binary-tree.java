class Solution {

    public int maxDepth(TreeNode root) {

        // Step 1: base case
        if (root == null) {
            return 0;
        }

        // Step 2: find depth of left and right subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Step 3: current depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
