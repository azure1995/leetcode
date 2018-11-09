import java.util.Collections;

/*
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (38.65%)
 * Total Accepted:    166.3K
 * Total Submissions: 430.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode guard = null;
        queue.add(root);
        queue.add(guard);
        List<Integer> list = new ArrayList<>();
        int layer = 0;
        while (true) {
            TreeNode head = queue.remove();
            if (head == null) {
                if ((layer++)%2==1) {
                    Collections.reverse(list);
                }
                result.add(list);
                if(queue.isEmpty()){
                    break;
                }
                list = new ArrayList<>();
                queue.add(guard);
            } else {
                list.add(head.val);
                if(head.left!=null){
                    queue.add(head.left);
                }
                if (head.right!=null) {
                    queue.add(head.right);
               } 
            }
        }
        return result;
    }
}
