/*
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (32.02%)
 * Total Accepted:    152K
 * Total Submissions: 474.6K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(0), cur = newHead;
        while (head1 != null || head2 != null) {
            if (head2 == null || (head1 != null && head1.val <= head2.val)) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode mid = head, end = head, pre = null;
        while (end != null && end.next != null) {
            pre = mid;
            mid = mid.next;
            end = end.next.next;
        }
        ListNode sorted_right = mergeSort(mid);
        pre.next = null;
        ListNode sorted_left = mergeSort(head);
        return merge(sorted_left, sorted_right);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
