/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ret = 0;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ret;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val + dfs(root.left) + dfs(root.right);
        ret += Math.abs(val - 1);    
        return val - 1;
    }
}