<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [116] Populating Next Right Pointers in Each Node
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * algorithms
 * Medium (36.55%)
 * Total Accepted:    200.2K
 * Total Submissions: 547.7K
 * Testcase Example:  '{}'
 *
 * Given a binary tree
 * 
 * 
 * struct TreeLinkNode {
 * ⁠ TreeLinkNode *left;
 * ⁠ TreeLinkNode *right;
 * ⁠ TreeLinkNode *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the
 * same level, and every parent has two children).
 * 
 * 
 * Example:
 * 
 * Given the following perfect binary tree,
 * 
 * 
 * ⁠    1
 * ⁠  /  \
 * ⁠ 2    3
 * ⁠/ \  / \
 * 4  5  6  7
 * 
 * 
 * After calling your function, the tree should look like:
 * 
 * 
 * ⁠    1 -> NULL
 * ⁠  /  \
 * ⁠ 2 -> 3 -> NULL
 * ⁠/ \  / \
 * 4->5->6->7 -> NULL
 * 
 * 
 */
/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeLinkNode pre = null;
        while (!queue.isEmpty()) {
            TreeLinkNode head = queue.remove();
            if (pre == null) {
                pre = head;
            } else {
                pre.next = head;
                pre = pre.next;
            }
            if (head != null) {
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            } else {
                if (queue.isEmpty()) {
                    return;
                }
                queue.add(null);
            }
        }
    }
}
=======
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [116] Populating Next Right Pointers in Each Node
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * algorithms
 * Medium (36.55%)
 * Total Accepted:    200.2K
 * Total Submissions: 547.7K
 * Testcase Example:  '{}'
 *
 * Given a binary tree
 * 
 * 
 * struct TreeLinkNode {
 * ⁠ TreeLinkNode *left;
 * ⁠ TreeLinkNode *right;
 * ⁠ TreeLinkNode *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the
 * same level, and every parent has two children).
 * 
 * 
 * Example:
 * 
 * Given the following perfect binary tree,
 * 
 * 
 * ⁠    1
 * ⁠  /  \
 * ⁠ 2    3
 * ⁠/ \  / \
 * 4  5  6  7
 * 
 * 
 * After calling your function, the tree should look like:
 * 
 * 
 * ⁠    1 -> NULL
 * ⁠  /  \
 * ⁠ 2 -> 3 -> NULL
 * ⁠/ \  / \
 * 4->5->6->7 -> NULL
 * 
 * 
 */
/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeLinkNode pre = null;
        while (!queue.isEmpty()) {
            TreeLinkNode head = queue.remove();
            if (pre == null) {
                pre = head;
            } else {
                pre.next = head;
                pre = pre.next;
            }
            if (head != null) {
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            } else {
                if (queue.isEmpty()) {
                    return;
                }
                queue.add(null);
            }
        }
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
