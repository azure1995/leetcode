<<<<<<< HEAD
/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (32.69%)
 * Total Accepted:    158.5K
 * Total Submissions: 484.8K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode guard = new ListNode(0), p = null, cur = guard, node = null;
        guard.next = head;
        while (count <= m) {
            p = cur;
            cur = cur.next;
            count++;
            if (count == m) {
                node = p;
            }
        }
        ListNode q = null;
        while (count <= n) {
            q = p;
            p = cur;
            cur = cur.next;
            p.next = q;
            count++;
        }
        node.next.next = cur;
        node.next = p;
        return guard.next;
    }
}
=======
/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (32.69%)
 * Total Accepted:    158.5K
 * Total Submissions: 484.8K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode guard = new ListNode(0), p = null, cur = guard, node = null;
        guard.next = head;
        while (count <= m) {
            p = cur;
            cur = cur.next;
            count++;
            if (count == m) {
                node = p;
            }
        }
        ListNode q = null;
        while (count <= n) {
            q = p;
            p = cur;
            cur = cur.next;
            p.next = q;
            count++;
        }
        node.next.next = cur;
        node.next = p;
        return guard.next;
    }
}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
