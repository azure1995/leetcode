<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

/*
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (37.67%)
 * Total Accepted:    148K
 * Total Submissions: 392.8K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode build(int from, int to) {
        if (from == to) {
            return null;
        }
        int mid = (from + to - 1) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(from, mid);
        root.right = build(mid + 1, to);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(0, list.size());
    }
}
=======
import java.util.ArrayList;
import java.util.List;

/*
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (37.67%)
 * Total Accepted:    148K
 * Total Submissions: 392.8K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode build(int from, int to) {
        if (from == to) {
            return null;
        }
        int mid = (from + to - 1) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(from, mid);
        root.right = build(mid + 1, to);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(0, list.size());
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
