class Solution {

    int postIndex;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // build inorder value -> index map
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                            int left, int right) {

        // base case
        if (left > right) {
            return null;
        }

        // pick root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // find root in inorder
        int mid = inorderMap.get(rootVal);

        // IMPORTANT: build right subtree first
        root.right = build(inorder, postorder, mid + 1, right);
        root.left  = build(inorder, postorder, left, mid - 1);

        return root;
    }
}
