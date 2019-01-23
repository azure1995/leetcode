/*
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (41.27%)
 * Total Accepted:    24.7K
 * Total Submissions: 59.8K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    }
}
