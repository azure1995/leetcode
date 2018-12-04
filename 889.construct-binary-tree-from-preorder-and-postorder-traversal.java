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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int i = 0;
        while (post[i++] != pre[1]);
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(post, 0, i));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, i + 1, pre.length),
                Arrays.copyOfRange(post, i, post.length - 1));
        return root;
    }
}
