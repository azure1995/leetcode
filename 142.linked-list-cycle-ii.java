<<<<<<< HEAD

/*
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (29.89%)
 * Total Accepted:    173K
 * Total Submissions: 578.9K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * 
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode byOneStep = head.next, byTwoStep = head.next.next;
        while (byOneStep != byTwoStep) {
            if (byOneStep == null) {
                return null;
            }
            byOneStep = byOneStep.next;
            if (byTwoStep == null || byTwoStep.next == null) {
                return null;
            }
            byTwoStep = byTwoStep.next.next;
        }
        ListNode finder = head;
        while (finder != byOneStep) {
            finder = finder.next;
            byOneStep = byOneStep.next;
        }
        return finder;
    }
}
=======

/*
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (29.89%)
 * Total Accepted:    173K
 * Total Submissions: 578.9K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * 
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode byOneStep = head.next, byTwoStep = head.next.next;
        while (byOneStep != byTwoStep) {
            if (byOneStep == null) {
                return null;
            }
            byOneStep = byOneStep.next;
            if (byTwoStep == null || byTwoStep.next == null) {
                return null;
            }
            byTwoStep = byTwoStep.next.next;
        }
        ListNode finder = head;
        while (finder != byOneStep) {
            finder = finder.next;
            byOneStep = byOneStep.next;
        }
        return finder;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
