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
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return Collections.EMPTY_LIST;
        } else if (N == 1) {
            return Collections.singletonList(new TreeNode(0));
        }
        List<TreeNode> ret = new ArrayList<>();
        for (int i = 1; i <= N - 2; i += 2) {
            List<TreeNode> lList = allPossibleFBT(i);
            List<TreeNode> rList = allPossibleFBT(N - 1 - i);
            for (TreeNode left : lList) {
                for (TreeNode right : rList) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
