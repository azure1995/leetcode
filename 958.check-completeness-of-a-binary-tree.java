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
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> curLevel = new LinkedList<>();
        curLevel.offerLast(root);
        while (!curLevel.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while (!curLevel.isEmpty()) {
                TreeNode node = curLevel.pollFirst();
                if (node.left != null && node.right != null) {
                    nextLevel.offerLast(node.left);
                    nextLevel.offerLast(node.right);
                } else if (node.left == null && node.right != null) {
                    return false;
                } else {
                    if (node.left != null) {
                        nextLevel.offerLast(node.left);
                    }
                    while (!curLevel.isEmpty()) {
                        TreeNode tmp = curLevel.pollFirst();
                        if (tmp.left != null || tmp.right != null) {
                            return false;
                        }
                    }
                    while (!nextLevel.isEmpty()) {
                        TreeNode tmp = nextLevel.pollFirst();
                        if (tmp.left != null || tmp.right != null) {
                            return false;
                        }
                    }
                }
            }
            curLevel = nextLevel;
        }
        return true;
    }
}