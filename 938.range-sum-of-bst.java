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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null || L > R) {
            return 0;
        }
        int ret = root.val >= L && root.val <= R ? root.val : 0;
        return ret + rangeSumBST(root.left, L, Math.min(R, root.val - 1))
                + rangeSumBST(root.right, Math.max(L, root.val + 1), R);
    }
}