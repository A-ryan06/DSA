class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // build value -> index map for inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // base case
        if (left > right) {
            return null;
        }

        // pick root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // find root in inorder
        int mid = inorderMap.get(rootVal);

        // build left and right subtree
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
