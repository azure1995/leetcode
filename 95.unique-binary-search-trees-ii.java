import java.util.ArrayList;
import java.util.List;

/*
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (33.43%)
 * Total Accepted:    115.1K
 * Total Submissions: 344.4K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode copyThenModify(TreeNode t, int increment) {
        if (t == null) {
            return null;
        }
        TreeNode c = new TreeNode(t.val + increment);
        c.left = copyThenModify(t.left, increment);
        c.right = copyThenModify(t.right, increment);
        return c;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> list = new ArrayList<>(n + 1);
        list.add(new ArrayList<>());
        list.get(0).add(null);
        for (int i = 1; i <= n; i++) {
            list.add(i, new ArrayList<>());
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : list.get(j - 1)) {
                    for (TreeNode right : list.get(i - j)) {
                        TreeNode node = new TreeNode(j);
                        node.left = left;
                        node.right = copyThenModify(right, j);
                        list.get(i).add(node);
                    }
                }
            }
        }
        return list.get(n);
    }
}
