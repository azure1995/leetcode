<<<<<<< HEAD
/*
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (36.07%)
 * Total Accepted:    125.6K
 * Total Submissions: 348.2K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int[] initial_postorder;
    int[] initial_inorder;

    public TreeNode build(int[] postRange, int[] inRange) {
        if (postRange[0] == postRange[1]) {
            return null;
        }
        TreeNode root = new TreeNode(initial_postorder[postRange[1] - 1]);
        int p = -1;
        for (int i = inRange[0]; i < inRange[1]; i++) {
            if (initial_inorder[i] == initial_postorder[postRange[1] - 1]) {
                p = i;
            }
        }
        int left_num = p - inRange[0];
        root.left = build(new int[] { postRange[0], left_num + postRange[0] }, new int[] { inRange[0], p });
        root.right = build(new int[] { left_num + postRange[0], postRange[1] - 1 }, new int[] { p + 1, inRange[1] });
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        initial_postorder = postorder;
        initial_inorder = inorder;
        return build(new int[] { 0, initial_postorder.length }, new int[] { 0, initial_inorder.length });
    }
}
=======
/*
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (36.07%)
 * Total Accepted:    125.6K
 * Total Submissions: 348.2K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int[] initial_postorder;
    int[] initial_inorder;

    public TreeNode build(int[] postRange, int[] inRange) {
        if (postRange[0] == postRange[1]) {
            return null;
        }
        TreeNode root = new TreeNode(initial_postorder[postRange[1] - 1]);
        int p = -1;
        for (int i = inRange[0]; i < inRange[1]; i++) {
            if (initial_inorder[i] == initial_postorder[postRange[1] - 1]) {
                p = i;
            }
        }
        int left_num = p - inRange[0];
        root.left = build(new int[] { postRange[0], left_num + postRange[0] }, new int[] { inRange[0], p });
        root.right = build(new int[] { left_num + postRange[0], postRange[1] - 1 }, new int[] { p + 1, inRange[1] });
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        initial_postorder = postorder;
        initial_inorder = inorder;
        return build(new int[] { 0, initial_postorder.length }, new int[] { 0, initial_inorder.length });
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
