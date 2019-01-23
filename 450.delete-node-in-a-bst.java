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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode globalPrev = null;
        boolean isLeft = false;
        while (cur != null) {
            if (cur.val == key) {
                if (cur.left != null) {
                    TreeNode rep = cur.left;
                    TreeNode localPrev = null;
                    while (rep.right != null) {
                        localPrev = rep;
                        rep = rep.right;
                    }
                    if (localPrev != null) {
                        localPrev.right = rep.left;
                    } else {
                        cur.left = rep.left;
                    }
                    cur.val = rep.val;
                } else if (cur.right != null) {
                    TreeNode rep = cur.right;
                    TreeNode localPrev = null;
                    while (rep.left != null) {
                        localPrev = rep;
                        rep = rep.left;
                    }
                    if (localPrev != null) {
                        localPrev.left = rep.right;
                    } else {
                        cur.right = rep.right;
                    }
                    cur.val = rep.val;
                } else {
                    if (globalPrev != null) {
                        if (isLeft) {
                            globalPrev.left = null;
                        } else {
                            globalPrev.right = null;
                        }
                    } else {
                        root = null;
                    }
                }
                break;
            } else {
                globalPrev = cur;
                isLeft = cur.val > key ? true : false;
                cur = cur.val > key ? cur.left : cur.right;
            }
        }
        return root;
    }
}