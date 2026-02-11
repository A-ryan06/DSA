class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Step 1
        if (p == null && q == null) return true;

        // Step 2
        if (p == null || q == null) return false;

        // Step 3
        if (p.val != q.val) return false;

        // Step 4
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
