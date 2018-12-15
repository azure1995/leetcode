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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null) {
                ret.add(stack.pop().val);
                continue;
            }
            if (t.left == null && t.right == null) {
                ret.add(t.val);
            } else {
                stack.add(t);
                stack.add(null);
                if (t.right != null) stack.add(t.right);
                if (t.left != null) stack.add(t.left);
            }
        }
        return ret;
    }
}
