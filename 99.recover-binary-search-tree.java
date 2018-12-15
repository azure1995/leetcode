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
    TreeNode first, second;

    public void inorderMorrisTraversal(TreeNode root) {
        TreeNode cur = root, temp = null, prev = null;
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.val > cur.val) {
                    if (first == null) {
                        first = prev;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            } else {
                temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    if (prev != null && prev.val > cur.val) {
                        if (first == null) {
                            first = prev;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    prev = cur;
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public void recoverTree(TreeNode root) {
        inorderMorrisTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
