/*
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (34.94%)
 * Total Accepted:    138.3K
 * Total Submissions: 395.8K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (leftHead == null) {
                    leftHead = new ListNode(cur.val);
                    leftTail = leftHead;
                } else {
                    leftTail.next = new ListNode(cur.val);
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = new ListNode(cur.val);
                    rightTail = rightHead;
                } else {
                    rightTail.next = new ListNode(cur.val);
                    rightTail = rightTail.next;
                }
            }
            cur = cur.next;
        }
        if (leftTail == null) {
            return rightHead;
        } else {
            leftTail.next = rightHead;
            return leftHead;
        }
    }
}
