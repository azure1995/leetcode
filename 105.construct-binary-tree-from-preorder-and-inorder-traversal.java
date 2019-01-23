import java.util.Arrays;

/*
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (37.03%)
 * Total Accepted:    170.9K
 * Total Submissions: 461.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int[] initial_preorder;
    int[] initial_inorder;

    public TreeNode build(int[] preRange, int[] inRange) {
        if (preRange[0] == preRange[1]) {
            return null;
        }
        TreeNode root = new TreeNode(initial_preorder[preRange[0]]);
        int p = -1;
        for (int i = inRange[0]; i < inRange[1]; i++) {
            if (initial_inorder[i] == initial_preorder[preRange[0]]) {
                p = i;
            }
        }
        int left_num = p - inRange[0];
        root.left = build(new int[] { 1 + preRange[0], left_num + preRange[0] + 1 }, new int[] { inRange[0], p });
        root.right = build(new int[] { left_num + preRange[0] + 1, preRange[1] }, new int[] { p + 1, inRange[1] });
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        initial_preorder = preorder;
        initial_inorder = inorder;
        return build(new int[] { 0, initial_preorder.length }, new int[] { 0, initial_inorder.length });
    }
}
