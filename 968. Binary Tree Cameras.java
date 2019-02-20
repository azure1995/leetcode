import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// if it's a leaf, return 0
// if it's parent with at least one child node which is a leaf (need a camera),
// return 1
// if it's parent of at least one node, of which dfs return 1, then return 2
// (covered)
class Solution {
    int ret = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == 0 ? 1 : 0) + ret;
    }

    private int dfs(TreeNode root) {
        int left = root.left == null ? 2 : dfs(root.left), right = root.right == null ? 2 : dfs(root.right);
        if (left == 0 || right == 0) {
            ret++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}