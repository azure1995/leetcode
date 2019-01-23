/*
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (31.09%)
 * Total Accepted:    152K
 * Total Submissions: 489K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null, pre = null, cur = head;
        while (cur != null) {
            int count = 1;
            while (cur.next != null && cur.val == cur.next.val) {
                count++;
                cur = cur.next;
            }
            if (count == 1) {
                if (newHead == null) {
                    newHead = cur;
                } else {
                    pre.next = cur;
                }
                pre = cur;
            }
            cur = cur.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return newHead;
    }
}
