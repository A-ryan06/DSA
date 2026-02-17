class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        dfs(root, targetSum, path, ans);
        return ans;
    }
    
    private void dfs(TreeNode node, int remainingSum, 
                     List<Integer> path, List<List<Integer>> ans) {
        
        if (node == null) return;
        
        path.add(node.val);
        remainingSum -= node.val;
        
        // If leaf node and sum matched
        if (node.left == null && node.right == null && remainingSum == 0) {
            ans.add(new ArrayList<>(path));
        }
        
        dfs(node.left, remainingSum, path, ans);
        dfs(node.right, remainingSum, path, ans);
        
        // Backtrack
        path.remove(path.size() - 1);
    }
}
