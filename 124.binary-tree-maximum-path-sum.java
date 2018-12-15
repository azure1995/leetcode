class Solution {
    int max = Integer.MIN_VALUE;

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, root.val + Math.max(0, Math.max(left + right, Math.max(left, right))));
        return Math.max(0, Math.max(root.val, root.val + Math.max(left, right)));
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}