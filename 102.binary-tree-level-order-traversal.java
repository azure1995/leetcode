<<<<<<< HEAD
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (44.97%)
 * Total Accepted:    286.2K
 * Total Submissions: 636.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode guard = null;
        queue.add(root);
        queue.add(guard);
        List<Integer> list = new ArrayList<>();
        while (true) {
            TreeNode head = queue.remove();
            if (head == null) {
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
=======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (44.97%)
 * Total Accepted:    286.2K
 * Total Submissions: 636.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode guard = null;
        queue.add(root);
        queue.add(guard);
        List<Integer> list = new ArrayList<>();
        while (true) {
            TreeNode head = queue.remove();
            if (head == null) {
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
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
