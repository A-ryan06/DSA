class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // empty tree
        if (start > end) {
            result.add(null);
            return result;
        }

        // try every number as root
        for (int rootVal = start; rootVal <= end; rootVal++) {

            List<TreeNode> leftTrees  = build(start, rootVal - 1);
            List<TreeNode> rightTrees = build(rootVal + 1, end);

            // combine all left and right trees
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}
