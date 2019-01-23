import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (37.72%)
 * Total Accepted:    189.9K
 * Total Submissions: 503.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null) {
                return result;
            }
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    result.add(list);
                }
                return result;
            }
            Stream<List<Integer>> paths = Stream.concat(pathSum(root.left, sum-root.val).stream(), pathSum(root.right, sum-root.val).stream());
            paths.forEach(path -> {
                path.add(0, root.val);
                result.add(path); 
            });
            return result;
        }
    }
}
